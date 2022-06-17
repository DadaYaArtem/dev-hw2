import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product product;

    @BeforeEach
    void beforeEach(){
        product = new Product("H", 6d, 14d, 11);
    }

    @Test
    void setPriceForOne(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> product.setPriceForOnePiece(-1),
                product.getPriceForOnePiece() + ""
        );

        product.setPriceForOnePiece(3d);
        Assertions.assertEquals(product.getPriceForOnePiece(),3d);
    }

    @Test
    void setAmount(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> product.setDiscountAmount(-1),
                product.getDiscountAmount() + ""
        );

        product.setDiscountAmount(10);
        Assertions.assertEquals(product.getDiscountAmount(),10d);
    }

    @Test
    void setDiscountAmountPrice(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> product.setPriceForDiscountAmount(-4),
                product.getPriceForDiscountAmount() + ""
        );

        product.setPriceForOnePiece(4d);
        Assertions.assertEquals(product.getPriceForOnePiece(),4d);
    }

}
