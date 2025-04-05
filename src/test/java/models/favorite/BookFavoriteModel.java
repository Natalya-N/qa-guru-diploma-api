package models.favorite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BookFavoriteModel {

    int id;
    String title;
    String url;

}
