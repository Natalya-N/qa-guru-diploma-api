package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.favorite.FavoriteBooksResponseModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import steps.FavoritesApiSteps;

import java.util.ArrayList;
import java.util.List;

@Epic("Избранное")
@Tag("regress")
public class FavoriteBooksTests extends TestBase {

    protected final FavoritesApiSteps favoritesApiSteps = new FavoritesApiSteps();

    @Story("Добавление и удаление книг из избранного")
    @CsvFileSource(resources = "/bookFavorites.csv")
    @ParameterizedTest(name = "Проверка добавления и удаления книг из избранного")
    public void addAndDeleteFavoriteBook(String bookId1, String bookName1, String bookId2, String bookName2) {
        FavoriteBooksResponseModel response = favoritesApiSteps.getFavoriteBooks(24);
        favoritesApiSteps.checkBooksAmount(0, response);
        favoritesApiSteps.addBookToFavorites(bookId1);
        favoritesApiSteps.addBookToFavorites(bookId2);
        FavoriteBooksResponseModel response1 = favoritesApiSteps.getFavoriteBooks(24);
        favoritesApiSteps.checkBooksAmount(2, response1);
        favoritesApiSteps.checkBooks(List.of(bookName1, bookName2), response1);
        favoritesApiSteps.deleteBookFromFavorites(bookId1);
        favoritesApiSteps.deleteBookFromFavorites(bookId2);
        FavoriteBooksResponseModel response2 = favoritesApiSteps.getFavoriteBooks(24);
        favoritesApiSteps.checkBooksAmount(0, response2);
    }
}
