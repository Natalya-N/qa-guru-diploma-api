package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.cart.CartResponseModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.CartApiSteps;

import static java.lang.Integer.parseInt;

@Epic("Работа с корзиной")
@Tag("regress")
public class CartTests extends TestBase {

    protected final CartApiSteps cartApiSteps = new CartApiSteps();

    @Story("Добавление книги в корзину")
    @Tag("smoke")
    @ValueSource(strings = {
            "71806174",
            "6994167"
    })
    @ParameterizedTest(name = "Добавить книгу с id {1} в корзину")
    public void addBookToCartTest(String id) {
        CartResponseModel response = cartApiSteps.addBookToCart(parseInt(id));
        cartApiSteps.checkCart(response, parseInt(id));
    }

}
