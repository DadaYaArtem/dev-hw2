import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductData {
    private static Map<String, Product> allProducts = new HashMap<>();

    static {
        Product prodA = new Product("A", 1.25d, 3d, 3d);
        Product prodB = new Product("B", 4.25d);
        Product prodC = new Product("C", 1d, 5d, 6d);
        Product prodD = new Product("D", 0.75d);

        allProducts.put(prodA.getId(), prodA);
        allProducts.put(prodB.getId(), prodB);
        allProducts.put(prodC.getId(), prodC);
        allProducts.put(prodD.getId(), prodD);
    }

    public static Map<String, Product> getAllProducts(){
        return new HashMap(allProducts);
    }

    public static void setAllProducts(Map<String, Product> newAllProducts){
        Objects.requireNonNull(newAllProducts);
        allProducts = newAllProducts;
    }

    public static double calculateCost(String expression) {
        int countA = 0;
        int countC = 0;
        double result = 0;
        if (Product.isProductIdValid(expression)) {
            char[] chars = expression.toCharArray();
            for (char c : chars) {
                switch (c) {
                    case 'A' -> {
                        if (countA == 2) {
                            double intermediateSum = allProducts.get("A").getPriceForDiscountAmount();
                            result += intermediateSum - allProducts.get("A").getPriceForOnePiece() * 2;
                            countA = 0;
                        } else {
                            result += allProducts.get("A").getPriceForOnePiece();
                            countA++;
                        }
                    }
                    case 'B' -> {
                        result += allProducts.get("B").getPriceForOnePiece();
                    }
                    case 'C' -> {
                        if (countC == 5) {
                            double intermediateSum = allProducts.get("C").getPriceForDiscountAmount();
                            result += intermediateSum - allProducts.get("C").getPriceForOnePiece() * 5;
                            countC = 0;
                        } else {
                            result += allProducts.get("C").getPriceForOnePiece();
                            countC++;
                        }
                    }
                    case 'D' -> {
                        result += allProducts.get("D").getPriceForOnePiece();
                    }
                }
            }
        }else {
            throw new IllegalArgumentException("Input not valid");
        }
        return result;
    }


}
