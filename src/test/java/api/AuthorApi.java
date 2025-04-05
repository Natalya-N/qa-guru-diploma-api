package api;

import io.qameta.allure.Step;
import models.author.AuthorResponseModel;
import models.author.NonExistedAuthorResponseErrorModel;

import static data.Constants.AUTHOR_PATH;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static specs.TestSpec.getBaseResponseSpec;
import static specs.TestSpec.requestSpec;

public class AuthorApi {

    @Step("Запросить профиль автора")
    public AuthorResponseModel getAuthorProfile(String name) {
        AuthorResponseModel response =
                given(requestSpec)
                        .when()
                        .get(AUTHOR_PATH + name)
                        .then()
                        .spec(getBaseResponseSpec(200))
                        .extract().as(AuthorResponseModel.class);
        return response;
    }

    @Step("Проверить полученные данные по профилю автора")
    public void checkAuthorProfile(AuthorResponseModel response,
                                   String name, int followers, int interviews) {
        assertNull(response.getError());
        assertEquals( 200, response.getStatus());
        assertEquals(name, response.getPayload().getData().getFullName());
        assertEquals(followers, response.getPayload().getData().getTotalFollowers());
        assertEquals(interviews, response.getPayload().getData().getInterviewsCount());
    }

    @Step("Запросить профиль несуществующего автора")
    public NonExistedAuthorResponseErrorModel getAuthorNonExistedProfile() {
        NonExistedAuthorResponseErrorModel response =
                given(requestSpec)
                        .when()
                        .get(AUTHOR_PATH + "non-existed")
                        .then()
                        .spec(getBaseResponseSpec(404))
                        .extract().as(NonExistedAuthorResponseErrorModel.class);
        return response;
    }

    @Step("Проверить появление ошибки при запросе несуществующего автора")
    public void checkNonExistedAuthorError(NonExistedAuthorResponseErrorModel response) {
        assertEquals("ResourceNotFoundByID", response.getError().getType());
        assertEquals("Resource not found", response.getError().getTitle());
        assertEquals("Could not find person with non-existed as an identifier", response.getError().getDetail());
        assertEquals("person", response.getError().getResourceType());
        assertEquals("non-existed", response.getError().getResourceId());
    }

}
