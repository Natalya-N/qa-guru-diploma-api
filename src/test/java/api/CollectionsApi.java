package api;

import io.qameta.allure.Step;
import models.book.BooksCollectionsResponseModel;

import static data.Constants.BOOKS_COLLECTIONS_PATH;
import static data.Constants.BOOKS_COUNT;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static specs.TestSpec.getBaseResponseSpec;
import static specs.TestSpec.requestSpec;

public class CollectionsApi {

    @Step("Получить коллекцию книг")
    public BooksCollectionsResponseModel getBooksCollections(int limit, int offset) {
        BooksCollectionsResponseModel response =
        given(requestSpec)
                .when()
                .param("limit", limit)
                .param("offset", offset)
                .get(BOOKS_COLLECTIONS_PATH)
                .then()
                .spec(getBaseResponseSpec(200))
                .extract().as(BooksCollectionsResponseModel.class);
        return response;

    }

    @Step("Проверить коллекцию книг")
    public void checkBooksCollections(BooksCollectionsResponseModel response,
                                      int index, int id, String name, String url) {
        assertNull(response.getError());
        assertEquals(200, response.getStatus());
        assertEquals(BOOKS_COUNT, response.getPayload().getCounters().getAll());
        assertEquals(id, response.getPayload().getData().get(index).getId());
        assertEquals(name, response.getPayload().getData().get(index).getName());
        assertEquals(url, response.getPayload().getData().get(index).getUrl());

    }

    @Step("Проверить пагинацию в выдаче коллекций книг")
    public void checkBooksCollectionPagination(BooksCollectionsResponseModel response, int limit, int offset) {
        int nextOffset = offset + 5;
        int previousOffset = offset - 5;
        assertNull(response.getError());
        assertEquals(200, response.getStatus());
        assertEquals(BOOKS_COUNT, response.getPayload().getCounters().getAll());
        assertEquals("/api/collections?limit=" + limit + "&offset=" + nextOffset, response.getPayload().getPagination().getNextPage());
        if (offset == 0)  {
            assertNull(response.getPayload().getPagination().getPreviousPage());
        } else {
            assertEquals("/api/collections?limit=" + limit + "&offset=" + previousOffset, response.getPayload().getPagination().getPreviousPage());
        }
    }

}
