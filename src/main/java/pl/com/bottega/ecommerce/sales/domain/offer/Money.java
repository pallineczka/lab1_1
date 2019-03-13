package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Money {

    private static String currency;

    private static BigDecimal value;

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public static String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public static BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Money money = (Money) o;
        return Objects.equals(currency, money.currency) && Objects.equals(value, money.value);
    }

    @Override public int hashCode() {
        return Objects.hash(currency, value);
    }
}
