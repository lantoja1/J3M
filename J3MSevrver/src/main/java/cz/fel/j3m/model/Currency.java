package cz.fel.j3m.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "currency")
public class Currency implements Serializable {

	@Id
	@Column(name = "currency_code")
	private String currencyCode;

	@NotNull
	@Column(name = "bid", nullable = false)
	private BigDecimal bid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bid_updated", nullable = true)
	private Date bidUpdated;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public Date getBidUpdated() {
		return bidUpdated;
	}

	public void setBidUpdated(Date bidUpdated) {
		this.bidUpdated = bidUpdated;
	}

	@Override
	public String toString() {
		return "Currency [currencyCode=" + currencyCode + ", bid=" + bid
				+ ", bidUpdated=" + bidUpdated + "]";
	}

}
