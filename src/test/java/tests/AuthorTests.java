package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.author.AuthorResponseModel;
import models.author.NonExistedAuthorResponseErrorModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import steps.AuthorApiSteps;

@Epic("Профиль автора")
@Tag("regress")
public class AuthorTests extends TestBase {

    protected final AuthorApiSteps authorApiSteps = new AuthorApiSteps();

    @Story("Получение информации о профиле автора")
    @CsvFileSource(resources = "/authorsList.csv")
    @ParameterizedTest(name = "Проверка профиля автора: " +
            "Для каждого автора должны возвращаться имя и фамилия: {2}, " +
            "Количество подписчиков {3} и количество интервью {4}")
    void getAuthorProfileTest(String uri, String name, int followers, int interviews) {
        AuthorResponseModel response = authorApiSteps.getAuthorProfile(uri);
        authorApiSteps.checkAuthorProfile(response, name, followers, interviews);
    }

    @Story("Получение информации о профиле автора")
    @Test
    @DisplayName("Проверка ошибки при запросе несуществующего автора")
    void getNonExistedAuthorTest() {
        NonExistedAuthorResponseErrorModel response = authorApiSteps.getAuthorNonExistedProfile();
        authorApiSteps.checkNonExistedAuthorError(response);
    }



}
