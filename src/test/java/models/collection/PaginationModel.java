package models.collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PaginationModel {

    @JsonProperty("next_page")
    String nextPage;
    @JsonProperty("previous_page")
    String previousPage;

}
