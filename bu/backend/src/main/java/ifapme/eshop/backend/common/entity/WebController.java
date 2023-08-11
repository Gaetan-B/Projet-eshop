package ifapme.eshop.backend.common.entity;

import org.springframework.stereotype.Controller;

@Controller
public class WebController {


    public String home() {
        return "index"; // Redirige vers la vue "index" (index.html, index.jsp, etc.)
    }
}
