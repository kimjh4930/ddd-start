package study.dddstart.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private Long id;
    private String orderNumber;
    private Money totalAmounts;

    private OrderState state;
    private ShippingInfo shippingInfo;

    private List<OrderLine> orderLines;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    public void setOrderLines(List<OrderLine> orderLines){
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
//        calculateTotalAmounts();
    }

    public void setShippingInfo(ShippingInfo shippingInfo){
        if(shippingInfo == null){
            throw new IllegalStateException("no ShippingInfo");
        }
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        this.shippingInfo = newShippingInfo;
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    public void changeShipped() {
        this.state = OrderState.SHIPPED;
    }


    public void completePayment() {

    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines){
        if(orderLines == null || orderLines.size() == 0){
            throw new IllegalStateException("no OrderLine");
        }
    }

    private void verifyNotYetShipped(){
        if(state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING){
            throw new IllegalStateException("already shipped.");
        }
    }


//    private void calculateTotalAmounts(){
//        this.totalAmounts = new Money(orderLines.stream()
//                                    .mapToInt(x -> x.)
//                                    .sum()
//                                    );
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(orderNumber, order.orderNumber) &&
                Objects.equals(totalAmounts, order.totalAmounts) &&
                state == order.state &&
                Objects.equals(shippingInfo, order.shippingInfo) &&
                Objects.equals(orderLines, order.orderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, totalAmounts, state, shippingInfo, orderLines);
    }
}
