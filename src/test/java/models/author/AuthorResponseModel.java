package models.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import models.author.AuthorPayloadModel;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AuthorResponseModel {

    int status;
    String error;
    AuthorPayloadModel payload;
}
