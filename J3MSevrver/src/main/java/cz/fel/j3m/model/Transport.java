package cz.fel.j3m.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "transport")
public class Transport implements Serializable {

    @Id
    @Column(name = "transport_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long transportId;

    @Column(name = "name")
    private String name;

    @Embedded
    private Price price;

}
