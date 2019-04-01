package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Discount {

    private Money value;

    private String cause;

    public Discount(String cause, Money value) {
        this.cause = cause;
        this.value = new Money(value.getValue(), value.getCurrency());
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Money getMoney() {
        return value;
    }

    public void setMoney(Money value) {
        this.value = value;
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
