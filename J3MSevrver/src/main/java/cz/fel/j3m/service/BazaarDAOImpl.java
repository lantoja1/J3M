package cz.fel.j3m.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cz.fel.j3m.model.BazaarOrder;
import cz.fel.j3m.model.OrderState;

@Repository
public class BazaarDAOImpl implements BazaarDAO {

	@PersistenceContext
	private EntityManager entityManger;

	@Override
	public List<BazaarOrder> findAllOrders() {
		Query q = entityManger.createNamedQuery("BazaarOrder.findAll");
		
		return q.getResultList();
	}

	@Override
	public List<BazaarOrder> findOrdersByState(Long state) {
		Query q = entityManger.createNamedQuery("BazaarOrder.findByState");
		q.setParameter("state", state);

		return q.getResultList();
	}
	
        @Override
	public OrderState findOrderState(Long state) {
            Query q = entityManger.createNamedQuery("OrderState.findByState");
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

}
