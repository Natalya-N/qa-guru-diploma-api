package tests;

import jdk.jfr.Description;
import models.collection.BooksCollectionsResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class BooksCollectionTests extends TestBase {

    @CsvFileSource(resources = "/booksCollection.csv")
    @ParameterizedTest(name = "Проверка коллекций книг: " +
            "Для каждой коллекции должны возвращаться идентификатор {2}, " +
            "Название {3} и url {4}")
    void getBooksCollectionTest(int index, int id, String name, String url, int count) {
        BooksCollectionsResponseModel response = collectionsApi.getBooksCollections(3, 0);
        collectionsApi.checkBooksCollections(response, index, id, name, url);

    }

    @Test
    @DisplayName("Проверка пагинации при получении коллекций книг")
    void getBooksCollectionPaginationTest() {
        BooksCollectionsResponseModel response1 = collectionsApi.getBooksCollections(5, 0);
        collectionsApi.checkBooksCollectionPagination(response1, 5, 0);
        BooksCollectionsResponseModel response2 = collectionsApi.getBooksCollections(5, 5);
    }

}
