package api;

import io.qameta.allure.Step;
import models.author.AuthorResponseModel;
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

public class CartApi {

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
        assertEquals(response.getStatus(), 200);
        assertEquals(response.getPayload().getData().getAddedArtIds(), books);

    }

    @Step("Удалить книгу из корзины")
    public void deleteBookFromCart(int id) {

        List<Integer> books = new ArrayList<>();
        books.add(id);
        CartModelRequest request  = new CartModelRequest();
        request.setArtIds(books);
        given(requestSpec)
                .when()
                .body(request)
                .delete(CART_PATH + REMOVE)
                .then()
                .spec(getBaseResponseSpec(204));
    }

}
