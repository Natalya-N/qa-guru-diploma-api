package api;

import io.qameta.allure.Step;
import models.author.AuthorResponseModel;
import models.cart.CartModelRequest;
import models.cart.CartResponseModel;

import java.util.ArrayList;
import java.util.List;

import static data.Constants.*;
import static io.restassured.RestAssured.given;
import static specs.TestSpec.getBaseResponseSpec;
import static specs.TestSpec.requestSpec;

public class CartApi {

    @Step("Добавить книгу в корзину")
    public void addBookToCart(int id) {

        List<Integer> books = new ArrayList<>();
        books.add(id);
        CartModelRequest request  = new CartModelRequest();
        request.setArtIds(books);
        given(requestSpec)
                .when()
                .body(request)
                .put(CART_PATH + ADD)
                .then()
                .spec(getBaseResponseSpec(200))
                .extract().as(AuthorResponseModel.class);

    }

    @Step("Получить содержимое корзины")
    public CartResponseModel getCart() {

        CartResponseModel response = given(requestSpec)
                .when()
                .get(CART_PATH)
                .then()
                .spec(getBaseResponseSpec(200))
                .extract().as(CartResponseModel.class);
        return response;
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

    @Step("Получить список книг по поисковому запросу")
    public void getBooksList(String query) {

        AuthorResponseModel response =
                given(requestSpec)
                        .when()
                        .param("limit", 25)
                        .param("offset", 0)
                        .param("show_unavailable", false)
                        .param("types", "text_book")
                        .param("q", query)
                        .get(SEARCH_PATH)
                        .then()
                        .spec(getBaseResponseSpec(200))
                        .extract().as(AuthorResponseModel.class);

        List<Integer> availableBooks = new ArrayList<>();
    }

}
