package cz.fel.j3m.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author j
 */
public class CurrencyTest {

	private Currency c;

	@Before
	public void init() {
		c = new Currency();
		c.setCurrencyCode("CZK");
		c.setBid(new BigDecimal(1));
		c.setBidUpdated(new Date());
	}

	@Test
	public void testWriteAndReadJSON() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String currencyJson = mapper.writeValueAsString(c);
		System.out.println(currencyJson);
		assertNotNull(currencyJson);

		Currency readCurrency = mapper.readValue(currencyJson, Currency.class);
		assertNotNull(readCurrency);
		assertEquals(c.getCurrencyCode(), readCurrency.getCurrencyCode());
		assertEquals(c.getBid(), readCurrency.getBid());
		assertEquals(c.getBidUpdated(), readCurrency.getBidUpdated());
	}

}
