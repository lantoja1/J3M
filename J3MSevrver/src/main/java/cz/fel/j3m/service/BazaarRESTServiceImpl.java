package cz.fel.j3m.service;

import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.fel.j3m.dao.BazaarDAO;
import cz.fel.j3m.model.BazaarOrder;
import cz.fel.j3m.model.OrderState;

@Component
@Path(value = "/")
public class BazaarRESTServiceImpl implements BazaarRESTService {

	private static final Log log = LogFactory
			.getLog(BazaarRESTServiceImpl.class);

	@Autowired
	private BazaarDAO dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.fel.j3m.service.BazaarRESTService#getHello(java.lang.String)
	 */
	@Override
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello(@QueryParam("msg") String msg) {
		return "AHOJ!" + msg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.fel.j3m.service.BazaarRESTService#getNewOrders()
	 */
	@Override
	@GET
	@Path("/orders")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<BazaarOrder> getNewOrders() {
		return dao.findOrdersByState(OrderState.NEW_STATE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.fel.j3m.service.BazaarRESTService#createNewOrders(java.util.List)
	 */
	// TODO userId
	@Override
	@PUT
	@Path("/new")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createNewOrders(@QueryParam("clientId") Long clientId,
									List<BazaarOrder> newOrders) {
		if (newOrders == null || newOrders.isEmpty()) {
			throw badRequestException();
		}

		try {
			dao.saveNewOrders(newOrders);
		} catch (Exception e) {
			log.error(e);
			throw internalServerError();
		}

		return Response.ok().build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.fel.j3m.service.BazaarRESTService#getOrder(java.lang.Long)
	 */
	@Override
	@GET
	@Path("/orders/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BazaarOrder getOrder(@PathParam("id") Long orderId) {
		BazaarOrder order = dao.findBazaarOrder(orderId);
		if (order == null) {
			throw notFoundException(orderId);
		}

		return order;
	}

	private NotFoundException notFoundException(Long orderId) {
		return new NotFoundException("Order with ID=" + orderId
				+ " does not exist.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cz.fel.j3m.service.BazaarRESTService#updateOrderStatus(cz.fel.j3m.model
	 * .BazaarOrder)
	 */
	@Override
	@PUT
	@Path("/orders")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BazaarOrder updateOrderStatus(	@QueryParam("clientId") Long clientId,
											BazaarOrder order) {
		if (order == null) {
			throw badRequestException();
		}

		try {
			return dao.updateOrder(order);
		} catch (Exception e) {
			log.error(e);
			throw internalServerError(e);
		}
	}

	private InternalServerErrorException internalServerError() {
		return new InternalServerErrorException("Oops, something went wrong!");
	}

	private InternalServerErrorException internalServerError(Exception e) {
		return new InternalServerErrorException("Oops, something went wrong!",
				e);
	}

	private BadRequestException badRequestException() {
		return new BadRequestException("Empty request body is not accepted.");
	}

}