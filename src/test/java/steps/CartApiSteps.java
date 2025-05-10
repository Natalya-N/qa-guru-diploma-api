package steps;

import io.qameta.allure.Step;
import models.cart.CartModelRequest;
import models.cart.CartResponseModel;

import java.util.ArrayList;
import java.util.List;

import static data.Constants.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static specs.TestSpec.getBaseResponseSpec;
import static specs.TestSpec.requestSpec;

public class CartApiSteps {

    @Step("Добавить книгу в корзину")
    public CartResponseModel addBookToCart(int id) {
        List<Integer> books = new ArrayList<>();
        books.add(id);
        CartModelRequest request  = new CartModelRequest();
        request.setArtIds(books);
        CartResponseModel response = given(requestSpec)
                .when()
                .body(request)
                .put(CART_PATH + ADD)
                .then()
                .spec(getBaseResponseSpec(200))
                .extract().as(CartResponseModel.class);
        return response;
    }

    @Step("Проверить содержимое корзины")
    public void checkCart(CartResponseModel response, int id) {
        List<Integer> books = new ArrayList<>();
        books.add(id);
        assertNull(response.getError());
        assertEquals(200, response.getStatus());
        assertEquals(books, response.getPayload().getData().getAddedArtIds());

    }

}
