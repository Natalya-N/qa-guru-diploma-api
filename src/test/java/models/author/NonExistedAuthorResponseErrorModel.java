package models.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import models.author.NonExistedAuthorErrorModel;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class NonExistedAuthorResponseErrorModel {

    String status;
    NonExistedAuthorErrorModel error;
}
