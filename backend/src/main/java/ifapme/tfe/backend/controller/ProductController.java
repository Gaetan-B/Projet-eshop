package ifapme.tfe.backend.controller;

import ifapme.tfe.backend.entity.Product;
import ifapme.tfe.backend.payload.ProductCreatePayload;
import ifapme.tfe.backend.payload.ProductUpdatePayload;
import ifapme.tfe.backend.payload.UserUpdatePayload;
import ifapme.tfe.backend.payload.response.ApiResponse;
import ifapme.tfe.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final String BASE_CODE = "api.products.";

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/list")
    public ApiResponse list() {
        return new ApiResponse(true, productRepository.findAll(), BASE_CODE + "list.success");
    }

    @GetMapping("/detail/{id}")
    public ApiResponse detail(@PathVariable UUID id) {
        return new ApiResponse(true, productRepository.findById(id), BASE_CODE + "detail.success");
    }

    @PostMapping("/create")
    public ApiResponse create(@RequestBody ProductCreatePayload payload) {
        try {
            Product product = new Product.ProductBuilder()
                    .setName(payload.getName())
                    .setDescription(payload.getDescription())
                    .setPrice(payload.getPrice())
                    .setReviews(payload.getReviews())
                    .setImages(payload.getImages()).build();
            Product newProduct = productRepository.save(product);
            return new ApiResponse(true, newProduct, BASE_CODE + "create.success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(false, null, BASE_CODE + "create.error");
        }
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody ProductUpdatePayload payload) {
        try {
            if (productRepository.findById(payload.getProduct_id()).isPresent()) {
                Product product = new Product.ProductBuilder()
                        .setName(payload.getName())
                        .setDescription(payload.getDescription())
                        .setPrice(payload.getPrice())
                        .setReviews(payload.getReviews())
                        .setImages(payload.getImages()).build();
            Product updatedProduct = productRepository.save(product);
            return new ApiResponse(true, updatedProduct, BASE_CODE + "update.success");
            } else {
                return new ApiResponse(true, null, BASE_CODE + "update.error.notfound");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  new ApiResponse(false, null, BASE_CODE + "update.error");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        try {
            productRepository.deleteById(id);
            return new ApiResponse(true, null, BASE_CODE + "delete.success");
        } catch (Exception e) {
            return new ApiResponse(false, null, BASE_CODE + "delete.error");
        }
    }

}
