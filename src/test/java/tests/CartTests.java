package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTests extends TestBase {

    @Test
    @DisplayName("")
    public void e2eCartScenarioTest() {
        cartApi.addBookToCart(71806174);
        cartApi.deleteBookFromCart(71806174);
    }

}
