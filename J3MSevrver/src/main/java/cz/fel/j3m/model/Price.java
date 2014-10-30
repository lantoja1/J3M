package cz.fel.j3m.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Price implements Serializable {
    
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    
    @Column(name = "currency", nullable = false)
    private String currency;

}
