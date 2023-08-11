package ifapme.tfe.backend.payload;

import ifapme.tfe.backend.entity.ProductImage;
import ifapme.tfe.backend.entity.ProductReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatePayload {
    private String name;
    private String description;
    private double price;
    private List<ProductReview> reviews;
    private List<ProductImage> images;
}
