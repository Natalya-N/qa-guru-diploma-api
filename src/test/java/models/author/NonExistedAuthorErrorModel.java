package models.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class NonExistedAuthorErrorModel {

    String type;

    String title;

    String detail;

    @JsonProperty("resource_type")
    String resourceType;

    @JsonProperty("resource_id")
    String resourceId;
}
