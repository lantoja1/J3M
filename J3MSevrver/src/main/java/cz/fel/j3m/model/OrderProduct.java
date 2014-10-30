package cz.fel.j3m.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "order_product")
public class OrderProduct implements Serializable {

    @EmbeddedId
    private OrderProductPK orderProductId;

    @Embedded
    private Price price;

    @Column(name = "discount", nullable = true)
    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "order")
    private Order order;

}
