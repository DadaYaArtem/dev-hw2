import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ProductDataTest {
    @Test
    public void calculateCostTest(){
        String[] invalidInputs = {
                "12",
                "aA",
                "AпBяC",
                "A1BB4"
        };
        for (String invalidInput : invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> ProductData.calculateCost(invalidInput),
                    invalidInput
            );
        }
    }

    @Test
    public void setAllProducts(){
        Product prodA = new Product("G", 5d,7d, 4);
        Product prodB = new Product("L",3d,8d,5);
        Map<String, Product> test = Map.of(prodA.getId(), prodA, prodB.getId(),prodB);
        ProductData.setAllProducts(test);
        Assertions.assertEquals(test, ProductData.getAllProducts());
    }
}