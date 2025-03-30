package tests;

import jdk.jfr.Description;
import models.author.AuthorResponseModel;
import models.author.NonExistedAuthorResponseErrorModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AuthorTests extends TestBase {

    @CsvFileSource(resources = "/authorsList.csv")
    @ParameterizedTest(name = "Проверка профиля автора: " +
            "Для каждого автора должны возвращаться имя и фамилия: {2}, " +
            "Количество подписчиков {3} и интервью {4}")
    @DisplayName("Проверка получения профиля автора")
    void getAuthorProfileTest(String uri, String name, int followers, int interviews) {
        AuthorResponseModel response = authorApi.getAuthorProfile(uri);
        authorApi.checkAuthorProfile(response, name, followers, interviews);
    }

    @Test
    @DisplayName("Проверка ошибки при запросе несуществующего автора")
    void getNonExistedAuthorTest() {
        NonExistedAuthorResponseErrorModel response = authorApi.getAuthorNonExistedProfile();
        authorApi.checkNonExistedAuthorError(response);
    }



}
