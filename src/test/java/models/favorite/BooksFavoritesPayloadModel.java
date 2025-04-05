package models.favorite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import models.book.CountersModel;
import models.book.PaginationModel;
import models.favorite.BookFavoriteModel;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BooksFavoritesPayloadModel {

    CountersModel counters;
    PaginationModel pagination;
    List<BookFavoriteModel> data;

}
