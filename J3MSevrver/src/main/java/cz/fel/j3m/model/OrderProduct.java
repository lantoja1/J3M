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
	private BazaarOrder order;

	public OrderProductPK getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(OrderProductPK orderProductId) {
		this.orderProductId = orderProductId;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BazaarOrder getOrder() {
		return order;
	}

	public void setOrder(BazaarOrder order) {
		this.order = order;
	}

}
