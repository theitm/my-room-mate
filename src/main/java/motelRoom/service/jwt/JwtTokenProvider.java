package motelRoom.service.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import motelRoom.service.userService.CustomUserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class JwtTokenProvider {

    private final String JWT_SECRET = "lodaaaaaa";

    /**Time jwt*/
    private final long JWT_EXPIRATION = 604800000L;

    /**Create jwt from user**/
    public String generateToken(CustomUserDetails userDetails){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        /**Create json web token by id from user.*/
        return Jwts.builder()
                .setSubject(String.valueOf(UUID.fromString(String.valueOf(userDetails.getUserEntity().getId()))))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    /***Get user from jwt**/
    public UUID getUserIdFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return UUID.fromString(claims.getSubject());
    }

     /** check token */
    public boolean validateToken(String authToken){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token: {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token: {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token: {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty: {}", ex.getMessage());
        }
        return false;
    }
}
