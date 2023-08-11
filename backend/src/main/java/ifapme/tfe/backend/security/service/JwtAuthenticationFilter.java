package ifapme.tfe.backend.security.service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.stereotype.Component;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//
//    @Autowired
//    private JwtTokenService jwtTokenService;
//
//    public JwtAuthenticationFilter() {
//        super(new AntPathRequestMatcher("/api/authenticate", "POST"));
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//            throws AuthenticationException, IOException, ServletException {
//
//        // Extract the token from the request and validate it
//        String token = extractTokenFromRequest(request);
//        // Validate token and get the username from it
//
//        // Replace 'username' with the actual username extracted from the token
//        String username = extractUsernameFromToken(token);
//
//        Authentication auth = new UsernamePasswordAuthenticationToken(username, null);
//        return getAuthenticationManager().authenticate(auth);
//    }
//
//    // ...
//
//    private String extractUsernameFromToken(String token) {
//        // Extract and decode the username from the token
//        return token;
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//                                            FilterChain chain, Authentication authResult)
//            throws IOException, ServletException {
//        // Generate a token and add it to the response
//        String token = jwtTokenService.generateToken(authResult.getName());
//        response.addHeader("Authorization", "Bearer " + token);
//    }
//
//    private String extractTokenFromRequest(HttpServletRequest request) {
//        // Extract token from the request, e.g., from header or request parameters
//        return null;
//    }
//}
