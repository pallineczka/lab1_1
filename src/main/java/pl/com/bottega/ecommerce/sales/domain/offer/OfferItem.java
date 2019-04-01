/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class OfferItem {

    private Product product;

    private Discount discount;

    private Money totalCost;

    private int quantity;

    private BigDecimal cost;

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType, int quantity) {
        this(productId, productPrice, productName, productSnapshotDate, productType, quantity, null, null);
    }

    public OfferItem(String id, String name, Date snapshotDate, String type, String cause, Money money1, int quantity) {
        this.product = new Product(id, name, snapshotDate, type, money1);
        this.discount = new Discount(cause, money1);
        this.totalCost = new Money(totalCost.getValue(), totalCost.getCurrency());
        this.quantity = quantity;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount.getMoney() != null) {
            discountValue = discountValue.subtract(discount.getMoney().getValue());
        }

        this.cost = product.getMoney().getValue().multiply(new BigDecimal(quantity)).subtract(discountValue);
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount.getMoney() == null ? 0 : discount.getMoney().hashCode());
        result = prime * result + quantity;
        result = prime * result + (totalCost.getValue() == null ? 0 : totalCost.getValue().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OfferItem other = (OfferItem) obj;
        if (discount == null) {
            if (other.discount != null) {
                return false;
            }
        } else if (!discount.equals(other.discount)) {
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }
        if (totalCost == null) {
            if (other.totalCost != null) {
                return false;
            }
        } else if (!totalCost.equals(other.totalCost)) {
            return false;
        }
        return true;
    }

    /**
     *
     * //@param item
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product.getName() == null) {
            if (other.product.getName() != null) {
                return false;
            }
        } else if (!product.getName().equals(other.product.getName())) {
            return false;
        }
        if (product.getMoney() == null) {
            if (other.product.getMoney() != null) {
                return false;
            }
        } else if (!product.getMoney().equals(other.product.getMoney())) {
            return false;
        }
        if (product.getId() == null) {
            if (other.product.getId() != null) {
                return false;
            }
        } else if (!product.getId().equals(other.product.getId())) {
            return false;
        }
        if (product.getType() != other.product.getType()) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (cost.compareTo(other.cost) > 0) {
            max = cost;
            min = other.cost;
        } else {
            max = other.cost;
            min = cost;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
