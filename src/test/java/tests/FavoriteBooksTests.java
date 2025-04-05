package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.favorite.FavoriteBooksResponseModel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

@Epic("Избранное")
public class FavoriteBooksTests extends TestBase{

    @Story("Добавление и удаление книг в избранное")
    @CsvFileSource(resources = "/bookFavorites.csv")
    @ParameterizedTest(name = "Проверка добавление и удаления книг в избранное")
    public void addAndDeleteFavoriteBook(String bookId1, String bookName1, String bookId2, String bookName2) {
        FavoriteBooksResponseModel response = favoritesApi.getFavoriteBooks(24);
        favoritesApi.checkBooksAmount(0, response);
        List<String> books = new ArrayList<>();
        favoritesApi.addBookToFavorites(bookId1);
        books.add(bookName1);
        favoritesApi.addBookToFavorites(bookId2);
        books.add(bookName2);
        FavoriteBooksResponseModel response1 = favoritesApi.getFavoriteBooks(24);
        favoritesApi.checkBooksAmount(2, response1);
        favoritesApi.checkBooks(books, response1);
        favoritesApi.deleteBookFromFavorites(bookId1);
        favoritesApi.deleteBookFromFavorites(bookId2);
        FavoriteBooksResponseModel response2 = favoritesApi.getFavoriteBooks(24);
        favoritesApi.checkBooksAmount(0, response2);
    }
}
