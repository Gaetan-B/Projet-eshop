package ifapme.tfe.backend.security.service;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class JwtTokenService {
//
//    @Value("${jwt.secret}")
//    private String jwtSecret;
//
//    @Value("${jwt.expiration}")
//    private int jwtExpiration;
//
//    public String generateToken(String username) {
//        Date expirationDate = new Date(System.currentTimeMillis() + jwtExpiration * 1000);
//
//        return Jwts.builder()
//                .setSubject(username)
//                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
//}
