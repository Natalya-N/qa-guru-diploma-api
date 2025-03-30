package models.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import models.author.AuthorModel;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AuthorPayloadModel {

    AuthorModel data;

}
