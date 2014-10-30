package cz.fel.j3m.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "order")
public class Order implements Serializable {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "state")
    private OrderState state;

    @ManyToOne
    @JoinColumn(name = "payment")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "transport")
    private Transport transport;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderProduct> products;

    @Embedded
    private Price total;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "street")
    private String street;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "house_num")
    private String houseNumber;

    @NotNull
    @Column(name = "zip")
    private String zip;

    @Column(name = "customer_note", length = 5000)
    private String customerNote;

    @NotNull
    @Column(name = "order_url")
    private String orderUrl;

    @NotNull
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

}
