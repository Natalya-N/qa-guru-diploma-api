package models.favorite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import models.favorite.BooksFavoritesPayloadModel;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FavoriteBooksResponseModel {

    int status;
    String error;
    BooksFavoritesPayloadModel payload;
}
