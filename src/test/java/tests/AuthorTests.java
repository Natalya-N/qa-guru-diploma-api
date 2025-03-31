package tests;

import models.author.AuthorResponseModel;
import models.author.NonExistedAuthorResponseErrorModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Tag("simple")
public class AuthorTests extends TestBase {

    @CsvFileSource(resources = "/authorsList.csv")
    @ParameterizedTest(name = "Проверка профиля автора: " +
            "Для каждого автора должны возвращаться имя и фамилия: {2}, " +
            "Количество подписчиков {3} и количество интервью {4}")
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
