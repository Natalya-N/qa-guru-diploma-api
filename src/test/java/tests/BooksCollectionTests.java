package tests;

import jdk.jfr.Description;
import models.collection.BooksCollectionsResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class BooksCollectionTests extends TestBase {

    @Test
    @DisplayName("Проверка получения коллекций книг")
    void getBooksCollectionTest() {
        BooksCollectionsResponseModel actual = collectionsApi.getBooksCollections(3, 0);
        assertNull(actual.getError());
        assertEquals(actual.getStatus(), 200);
        assertEquals(actual.getPayload().getCounters().getAll(), 9150);
// доработать методы + модель
    }

    @Test
    @DisplayName("Проверка пагинации при получении коллекций книг")
    void getBooksCollectionPaginationTest() {
        BooksCollectionsResponseModel actual = collectionsApi.getBooksCollections(5, 0);
        assertNull(actual.getError());
        assertEquals(actual.getStatus(), 200);
        assertEquals(actual.getPayload().getCounters().getAll(), 9150);
        assertEquals(actual.getPayload().getPagination().getNextPage() , "/api/collections?limit=5&offset=5");
        assertNull(actual.getPayload().getPagination().getPreviousPage());
        BooksCollectionsResponseModel actual2 = collectionsApi.getBooksCollections(5, 5);
        assertNull(actual2.getError());
        assertEquals(actual2.getStatus(), 200);
        assertEquals(actual2.getPayload().getCounters().getAll(), 9150);
        assertEquals(actual2.getPayload().getPagination().getNextPage() , "/api/collections?limit=5&offset=10");
        assertEquals(actual2.getPayload().getPagination().getPreviousPage() , "/api/collections?limit=5&offset=0");
    }

}
