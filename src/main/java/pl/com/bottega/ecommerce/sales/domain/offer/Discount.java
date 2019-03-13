package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Discount {

    private Money money;

    private String cause;

    public Discount(String cause, Money money) {
        this.cause = cause;
        this.money = new Money(Money.getValue(), Money.getCurrency());
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Discount discount = (Discount) o;
        return Objects.equals(cause, discount.cause);
    }

    @Override public int hashCode() {
        return Objects.hash(cause);
    }
}
