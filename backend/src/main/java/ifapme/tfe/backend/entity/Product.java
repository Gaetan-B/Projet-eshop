package ifapme.tfe.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "product_id", updatable = false, nullable = false)
    private UUID product_id;

    private String name;
    private String description;
    private double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductReview> reviews;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images;

    public static class ProductBuilder {
        UUID product_id;
        String name;
        String description;
        double price;
        List<ProductReview> reviews;
        List<ProductImage> images;

        public ProductBuilder setProduct_id(UUID product_id) {
            this.product_id = product_id;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setReviews(List<ProductReview> reviews) {
            this.reviews = reviews;
            return this;
        }

        public ProductBuilder setImages(List<ProductImage> images) {
            this.images = images;
            return this;
        }

        public Product build() { return new Product(product_id, name, description, price, reviews, images); }

    }
}
