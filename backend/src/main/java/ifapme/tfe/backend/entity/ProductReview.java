package ifapme.tfe.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReview {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "preview_id", updatable = false, nullable = false)
    private UUID preview_id;

    @ManyToOne
    private Product product;

    private int rating; // Note sur 5
    private String comment; // Commentaire de l'utilisateur

    // Constructeurs, getters, setters


    public ProductReview(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and setters
    public UUID getId() {
        return preview_id;
    }

    public void setId(UUID id) {
        this.preview_id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
