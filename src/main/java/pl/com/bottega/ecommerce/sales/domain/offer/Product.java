package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private String id;

    private BigDecimal price;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String id, BigDecimal price, String name, Date snapshotDate, String type){
        this(id, price, name, snapshotDate, type);
    }

    public Product(String id, BigDecimal price, String name, Date snapshotDate, String type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getid() {
        return id;
    }

    public BigDecimal getprice() {
        return price;
    }

    public String getname() {
        return name;
    }

    public Date getsnapshotDate() {
        return snapshotDate;
    }

    public String gettype() {
        return type;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        if (name == null) {
            if (product.name != null) {
                return false;
            }
        } else if (!name.equals(product.name)) {
            return false;
        }
        if (price == null) {
            if (product.price != null) {
                return false;
            }
        } else if (!price.equals(product.price)) {
            return false;
        }
        if (id == null) {
            if (product.id != null) {
                return false;
            }
        } else if (!id.equals(product.id)) {
            return false;
        }
        if (type != product.type) {
            return false;
        }
        return true;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (price == null ? 0 : price.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (type == null ? 0 : type.hashCode());
        return result;
    }
}
