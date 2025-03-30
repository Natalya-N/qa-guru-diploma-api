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
        assertEquals(response.getStatus(), 200);
        assertEquals(response.getPayload().getData().getFullName(), name);
        assertEquals(response.getPayload().getData().getTotalFollowers(), followers);
        assertEquals(response.getPayload().getData().getInterviewsCount(), interviews);
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

    @Step("Проверить поялвение ошибки при запросе несуществующего автора")
    public void checkNonExistedAuthorError(NonExistedAuthorResponseErrorModel response) {
        assertEquals(response.getError().getType(), "ResourceNotFoundByID");
        assertEquals(response.getError().getTitle(), "Resource not found");
        assertEquals(response.getError().getDetail(), "Could not find person with non-existed as an identifier");
        assertEquals(response.getError().getResourceType(), "person");
        assertEquals(response.getError().getResourceId(), "non-existed");
    }

}
