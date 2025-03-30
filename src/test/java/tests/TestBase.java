package tests;

import api.AuthorApi;
import api.CartApi;
import api.CollectionsApi;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected final CollectionsApi collectionsApi = new CollectionsApi();
    protected final AuthorApi authorApi = new AuthorApi();
    protected final CartApi cartApi = new CartApi();

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://api.litres.ru";
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


}
