package cz.fel.j3m.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cz.fel.j3m.model.BazaarOrder;
import cz.fel.j3m.model.OrderState;

@Repository
public class BazaarDAOImpl implements BazaarDAO {

	@PersistenceContext
	private EntityManager entityManger;

	@Override
	public List<BazaarOrder> findAllOrders() {
		TypedQuery<BazaarOrder> q = entityManger.createNamedQuery(
				"BazaarOrder.findAll", BazaarOrder.class);

		return q.getResultList();
	}

	@Override
	public List<BazaarOrder> findOrdersByState(Long state) {
		TypedQuery<BazaarOrder> q = entityManger.createNamedQuery(
				"BazaarOrder.findByState", BazaarOrder.class);
		q.setParameter("state", state);

		return q.getResultList();
	}

	@Override
	public List<OrderState> findAllStates() {
		TypedQuery<OrderState> q = entityManger.createNamedQuery(
				"OrderState.findAll", OrderState.class);
		return q.getResultList();
	}

	@Override
	public OrderState findOrderState(Long state) {
		TypedQuery<OrderState> q = entityManger.createNamedQuery(
				"OrderState.findByState", OrderState.class);
		q.setParameter("state", state);

		List<OrderState> states = q.getResultList();
		if (!states.isEmpty()) {
			return states.get(0);
		}
		return null;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManger;
	}

	@Override
	public <E> void persist(E entity) {
		entityManger.persist(entity);
	}

	@Override
	public void saveNewOrders(List<BazaarOrder> orders) throws Exception {
		for (BazaarOrder order : orders) {
			BazaarOrder find = entityManger.find(BazaarOrder.class,
					order.getOrderId());

			if (find == null) {
				entityManger.persist(order);
			} else {
				entityManger.merge(order);
			}
		}
	}

	@Override
	public BazaarOrder findBazaarOrder(Long orderId) {
		return entityManger.find(BazaarOrder.class, orderId);
	}

	@Override
	public BazaarOrder updateOrder(BazaarOrder order) throws Exception {
		BazaarOrder managed = entityManger.find(BazaarOrder.class,
				order.getOrderId());

		if (managed == null) {
			throw new EntityNotFoundException();
		}

		managed.setState(order.getState());
		return entityManger.merge(managed);
	}

}
