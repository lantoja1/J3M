package cz.fel.j3m.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "order_state")
public class OrderState implements Serializable {

    @Id
    @Column(name = "order_state_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderStateId;

    @Column(name = "name")
    private String name;

}
