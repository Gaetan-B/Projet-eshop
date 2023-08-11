package ifapme.tfe.backend.security.service;

import ifapme.tfe.backend.payload.response.ApiResponse;

import java.util.UUID;

public interface ProductService {
    ApiResponse create();

    ApiResponse update();

    ApiResponse read(UUID id);

    ApiResponse delete(UUID id);
}
