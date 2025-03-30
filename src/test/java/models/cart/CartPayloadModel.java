package models.cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import models.collection.PaginationModel;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CartPayloadModel {

    CartModel data;

}
