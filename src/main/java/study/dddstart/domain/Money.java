package study.dddstart.domain;

public class Money {

    private int money;

    public Money(int money){
        this.money = money;
    }

    public int getValue(){
        return this.money;
    }

    public Money add(Money money){
        return new Money(this.money + money.getValue());
    }

    public Money multiply(int multiplier){
        return new Money(this.money * multiplier);
    }
}
