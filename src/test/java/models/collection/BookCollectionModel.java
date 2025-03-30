package models.collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BookCollectionModel {

    int id;
    String name;
    String url;
}
