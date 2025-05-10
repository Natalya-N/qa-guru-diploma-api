package steps;

import io.qameta.allure.Step;
import models.favorite.FavoriteBooksResponseModel;

import java.util.ArrayList;
import java.util.List;

import static data.Constants.FAVORITE_BOOKS_PATH;
import static data.Constants.SESSION_ID;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.TestSpec.getBaseResponseSpec;
import static specs.TestSpec.requestSpec;

public class FavoritesApiSteps {

    @Step("Получить список избранных книг")
    public FavoriteBooksResponseModel getFavoriteBooks(int limit) {
        FavoriteBooksResponseModel response =
                given(requestSpec)
                        .when()
                        .param("limit", limit)
                        .header("Session-id", SESSION_ID)
                        .get(FAVORITE_BOOKS_PATH)
                        .then()
                        .spec(getBaseResponseSpec(200))
                        .extract().as(FavoriteBooksResponseModel.class);
        return response;

    }

    @Step("Проверить количество книг в избранном")
    public void checkBooksAmount(int amount, FavoriteBooksResponseModel response) {
        assertEquals(amount, response.getPayload().getData().size());

    }

    @Step("Проверить книги в ответе")
    public void checkBooks(List<String> books, FavoriteBooksResponseModel response) {
        int n = response.getPayload().getData().size() - 1;
        List<String> responseBooks = new ArrayList<>();
        do {
            responseBooks.add(response.getPayload().getData().get(n).getTitle());
            n--;
        }
        while (n >= 0);
        for (String name : responseBooks) {
            assertTrue(books.contains(name));
        }

    }

    @Step("Добавить книгу в избранное")
    public void addBookToFavorites(String book) {
        given(requestSpec)
                .when()
                .header("Session-id", SESSION_ID)
                .put(FAVORITE_BOOKS_PATH + "/" + book)
                .then()
                .spec(getBaseResponseSpec(204));
    }

    @Step("Удалить книгу из избранного")
    public void deleteBookFromFavorites(String book) {
        given(requestSpec)
                .when()
                .header("Session-id", SESSION_ID)
                .delete(FAVORITE_BOOKS_PATH + "/" + book)
                .then()
                .spec(getBaseResponseSpec(204));
    }
}
