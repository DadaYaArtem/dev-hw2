import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Objects;

@NoArgsConstructor
public class Product {

    private String id;
    private double priceForOnePiece;
    private double discountAmount;
    private double priceForDiscountAmount;

    public Product(String id, double priceForOnePiece, double priceForDiscountAmount, double discountAmount) {
        if (isProductIdValid(id) && isPriceOk(priceForOnePiece) && isPriceOk(priceForDiscountAmount) && isAmountOk(discountAmount)) {
            this.id = id;
            this.priceForOnePiece = priceForOnePiece;
            this.priceForDiscountAmount = priceForDiscountAmount;
            this.discountAmount = discountAmount;
        }
    }

    public Product(String id, double priceForOnePiece) {
        this.id = id;
        this.priceForOnePiece = priceForOnePiece;
    }

    public String getId() {
        return id;
    }

    public double getPriceForOnePiece() {
        return priceForOnePiece;
    }


    public double getPriceForDiscountAmount() {
        return priceForDiscountAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setPriceForOnePiece(double priceForOnePiece) {
        if (isPriceOk(priceForOnePiece)) {
            this.priceForOnePiece = priceForOnePiece;
        }
    }

    public void setPriceForDiscountAmount(double priceForDiscountAmount) {
        if (isPriceOk(priceForDiscountAmount)) {
            this.priceForDiscountAmount = priceForDiscountAmount;
        }
    }

    public void setDiscountAmount(long discountAmount) {
        if (isAmountOk(discountAmount)) {
            this.discountAmount = discountAmount;
        }
    }

    //actually bete to say "isPriceGreaterThenZero" or something similar
    //"OK" can have several meanings
    public static boolean isPriceOk(double price) {
        if (price > 0) {
            return true;
        } else {
            throw new IllegalArgumentException("Price is not valid");
        }
    }

    public static boolean isAmountOk(double amount) {
        if (amount > 0) {
            return true;
        } else {
            throw new IllegalArgumentException("Amount is not valid");
        }
    }

    public static boolean isProductIdValid(String productId) {
        char[] chars = productId.trim().toCharArray();
        String allPossibleIds = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char aChar : chars) {
            if (allPossibleIds.contains(Character.toString(aChar))) {
                continue;
            } else {
                throw new IllegalArgumentException("Not valid ID");
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", priceForOnePiece=" + priceForOnePiece +
                ", discountAmount=" + discountAmount +
                ", priceForDiscountAmount=" + priceForDiscountAmount +
                '}';
    }
}


