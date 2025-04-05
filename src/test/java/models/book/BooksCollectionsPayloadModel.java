package models.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BooksCollectionsPayloadModel {

    CountersModel counters;
    PaginationModel pagination;
    List<BookModel> data;

}
