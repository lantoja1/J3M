package cz.fel.j3m.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import testutils.TestUtils;
import cz.fel.j3m.model.BazaarOrder;
import cz.fel.j3m.model.Currency;
import cz.fel.j3m.model.OrderState;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/WEB-INF/context/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
// extend the transactions to whole tests in order to roll back the tests
@Transactional
public class BazaarDAOImplTest {

	@Autowired
	private BazaarDAO dao;

	@Test
	public void testFindAllOrders() {
		Currency c = TestUtils.getTestCurrency();
		dao.persist(c);

		BazaarOrder o = TestUtils.getTestOrder(c);
		dao.persist(o);

		List<BazaarOrder> orders = dao.findAllOrders();
		assertEquals(1, orders.size());

		BazaarOrder order = orders.get(0);
		assertEquals(o.getPrice().getAmount(), order.getPrice().getAmount());
	}

	@Test
	public void testGetEntityManager() {
		assertNotNull(dao.getEntityManager());
	}

	@Test
	public void testFindNewOrders() {
		Currency c = TestUtils.getTestCurrency();
		dao.persist(c);

		BazaarOrder o = TestUtils.getTestOrder(c);
		BazaarOrder o2 = TestUtils.getTestOrder(c);
		OrderState s1 = dao.findOrderState(OrderState.NEW_STATE);
		OrderState s2 = dao.findOrderState(OrderState.PROCESSED_STATE);
		o.setState(s1);
		o2.setState(s2);

		dao.persist(o);
		dao.persist(o2);

		List<BazaarOrder> newOrders = dao
				.findOrdersByState(OrderState.NEW_STATE);
		assertEquals(1, newOrders.size());

		BazaarOrder newOrder = newOrders.get(0);
		assertEquals(o, newOrder);
	}

}
