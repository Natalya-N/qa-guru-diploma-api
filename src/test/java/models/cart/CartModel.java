package models.cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CartModel {
    @JsonProperty("added_art_ids")
    List<Integer> addedArtIds;

    @JsonProperty("failed_art_ids")
    List<Integer> failedArtIds;

}
