package testutils;

import java.math.BigDecimal;
import java.util.Date;

import cz.fel.j3m.model.BazaarOrder;
import cz.fel.j3m.model.Currency;
import cz.fel.j3m.model.Price;

public class TestUtils {

	public static BazaarOrder getTestOrder(Currency currency) {
		BazaarOrder order = new BazaarOrder();
		order.setCity("test mesto");
		order.setEmail("test mail");
		order.setFirstName("test first name");
		order.setSurname("test surname");
		order.setHouseNumber("test house number");
		order.setOrderDate(new Date());
		order.setZip("test zip");
		order.setOrderUrl("test order url");

		Price price = new Price();
		price.setAmount(new BigDecimal(100.90));
		price.setCurrency(currency);
		order.setPrice(price);

		return order;
	}

	public static Currency getTestCurrency() {
		Currency currency = new Currency();
		currency.setCurrencyCode("CZK");
		currency.setBid(BigDecimal.ONE);
		currency.setBidUpdated(new Date());
		return currency;
	}
}
