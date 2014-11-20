package cz.cvut.fel.j3mclient.app.service;


import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Put;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import cz.cvut.fel.j3mclient.app.model.BazaarOrder;

import java.util.List;

/**
 *
 * Created by Lantty on 20.11.2014.
 */
@Rest(rootUrl = "", converters = { MappingJacksonHttpMessageConverter.class })
public interface BazaarRestService {

    @Get("/neworders")
    public List<BazaarOrder> getNewOrders();

    @Get("order/{id}")
    public BazaarOrder getOrder(Long id);

    @Put("/order")
    public void updateOrder(BazaarOrder order);


}
