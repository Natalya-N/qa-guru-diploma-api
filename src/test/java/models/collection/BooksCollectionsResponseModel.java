package models.collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import models.collection.BooksCollectionsPayloadModel;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BooksCollectionsResponseModel {

    int status;
    String error;
    BooksCollectionsPayloadModel payload;

}
