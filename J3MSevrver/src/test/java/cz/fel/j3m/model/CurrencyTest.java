package cz.fel.j3m.model;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

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
//		ObjectMapper mapper = new ObjectMapper();
//		String currencyJson = mapper.writeValueAsString(Arrays.asList(c, c));
//		System.out.println(currencyJson);
//		assertNotNull(currencyJson);
//
//		List<Currency> readCurrency = mapper.readValue(currencyJson, new TypeReference<List<Currency>>(){});
//		assertNotNull(readCurrency);
//		assertFalse(readCurrency.isEmpty());
//		assertEquals(c.getCurrencyCode(), readCurrency.get(0).getCurrencyCode());
//		assertEquals(c.getBid(), readCurrency.get(0).getBid());
//		assertEquals(c.getBidUpdated(), readCurrency.get(0).getBidUpdated());
	}

}
