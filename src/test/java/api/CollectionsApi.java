package api;

import io.qameta.allure.Step;
import models.collection.BooksCollectionsResponseModel;

import static data.Constants.BOOKS_COLLECTIONS_PATH;
import static io.restassured.RestAssured.given;
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

}
