package study.dddstart.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShippingInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Receiver receiver;

    @Embedded
    private Address address;

    private String message;

    public ShippingInfo (){

    }

    public Long getId() {
        return id;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public Address getAddress() {
        return address;
    }

    public String getMessage() {
        return message;
    }
}
