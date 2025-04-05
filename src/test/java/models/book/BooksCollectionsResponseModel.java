package models.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BooksCollectionsResponseModel {

    int status;
    String error;
    BooksCollectionsPayloadModel payload;

}
