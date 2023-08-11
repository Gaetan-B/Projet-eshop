package ifapme.tfe.backend.security.service.impl;

import ifapme.tfe.backend.constant.ApiCode;
import ifapme.tfe.backend.payload.response.ApiResponse;
import ifapme.tfe.backend.security.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ApiResponse create() {
        return null;
    }

    @Override
    public ApiResponse update() {
        return null;
    }

    @Override
    public ApiResponse read(UUID id) {
        try {
            return new ApiResponse(true, "", "");

        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage(), ApiCode.ACCOUNT_READ_SYSTEM_ERROR);
        }
    }

    @Override
    public ApiResponse delete(UUID id) {
        return null;
    }
}
