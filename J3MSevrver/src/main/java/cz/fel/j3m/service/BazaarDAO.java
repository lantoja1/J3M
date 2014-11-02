package cz.fel.j3m.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import cz.fel.j3m.model.BazaarOrder;
import cz.fel.j3m.model.OrderState;

public interface BazaarDAO {

	@Transactional(readOnly = true)
	public List<BazaarOrder> findAllOrders();
	
	@Transactional(readOnly= true)
	public List<BazaarOrder> findOrdersByState(Long state);

        @Transactional
        public OrderState findOrderState(Long state);
        
	@Transactional
	public <E> void persist(E entity);

	public EntityManager getEntityManager();

}
