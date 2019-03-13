package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private Money money;

    private String id;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String id, String name, Date snapshotDate, String type, Money money) {
        this.id = id;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
        this.money = new Money(Money.getValue(), Money.getCurrency());
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(money, product.money)
               && Objects.equals(id, product.id)
               && Objects.equals(name, product.name)
               && Objects.equals(snapshotDate, product.snapshotDate)
               && Objects.equals(type, product.type);
    }

    @Override public int hashCode() {
        return Objects.hash(money, id, name, snapshotDate, type);
    }
}
