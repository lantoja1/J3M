package cz.fel.j3m.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "bazar_product")
public class BazarProduct implements Serializable {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    @Column(name = "name")
    private String name;

    @Column(name = "product_size")
    private String productSize;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> photoUrl;

    @Embedded
    private Price price;

}
