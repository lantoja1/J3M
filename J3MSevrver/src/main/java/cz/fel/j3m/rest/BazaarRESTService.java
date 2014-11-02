package cz.fel.j3m.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.fel.j3m.model.BazaarOrder;
import cz.fel.j3m.model.OrderState;
import cz.fel.j3m.service.BazaarDAO;

@Component
@Path(value = "/")
public class BazaarRESTService {

	@Autowired
	private BazaarDAO dao;

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello(@QueryParam("msg") String msg) {
		return "AHOJ!" + msg;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BazaarOrder> getNewOrders() {
		return dao.findOrdersByState(OrderState.NEW_STATE);
	}

	public BazaarDAO getDao() {
		return dao;
	}

	public void setDao(BazaarDAO dao) {
		this.dao = dao;
	}

}
