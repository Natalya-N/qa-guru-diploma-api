package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.book.BooksCollectionsResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Epic("Коллекции книг")
@Tag("regress")
public class BooksCollectionTests extends TestBase {

    @Story("Получение коллекции книг")
    @CsvFileSource(resources = "/bookCollection.csv")
    @ParameterizedTest(name = "Проверка коллекций книг: " +
            "Для каждой коллекции должны возвращаться идентификатор {2}, " +
            "Название {3} и url {4}")
    void getBooksCollectionTest(int index, int id, String name, String url) {
        BooksCollectionsResponseModel response = collectionsApi.getBooksCollections(3, 0);
        collectionsApi.checkBooksCollections(response, index, id, name, url);

    }

    @Story("Получение коллекции книг")
    @Test
    @DisplayName("Проверка пагинации при получении коллекций книг")
    void getBooksCollectionPaginationTest() {
        BooksCollectionsResponseModel response1 = collectionsApi.getBooksCollections(5, 0);
        collectionsApi.checkBooksCollectionPagination(response1, 5, 0);
        BooksCollectionsResponseModel response2 = collectionsApi.getBooksCollections(5, 5);
        collectionsApi.checkBooksCollectionPagination(response2, 5, 5);
    }

}
