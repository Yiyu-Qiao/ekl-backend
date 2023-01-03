package de.han.ekl.backend.token;

import de.han.ekl.backend.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//TODO refactoring
@Component
public class JWTProvider {

    public String createJWT (User user){
        Assert.notNull(user, "User muss not be null for creation JWT");
        Assert.notNull(user.getUsername(), "User name muss not be null for creation JWT");
        Claims claims = Jwts.claims();
        claims.setIssuer("EKL JWT Provider");
        claims.setSubject(user.getUsername());
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("/UB0VoEUQn9ecTqPaE6XlbtpbsupRaAtifHXfxEFSDA="));
        String jwt = Jwts.builder().setClaims(claims).signWith(key, SignatureAlgorithm.HS256).compact();
        return jwt;
    }

    public Jwt createSpringSecurityJwtWith(String token, Jws<Claims> jws){
        Map<String, Object> claims = jws.getBody().keySet().stream().collect(Collectors.toMap(key -> key, key -> jws.getBody().get(key), (a, b) -> b));
//        Map<String, Object> claims = new HashMap();
//        for(Object claim : jws.getBody().keySet()){
//            claims.put((String) claim, jws.getBody().get(claim));
//        }

        Map<String, Object> headers =new HashMap();
        for(Object header : jws.getHeader().keySet()){
            headers.put((String)header, jws.getHeader().get(header));
        }

        Instant expiration = LocalDateTime.now().toInstant(ZoneId.systemDefault().getRules().getOffset(LocalDateTime.now())).plusSeconds(3600);
        if(jws.getBody().getExpiration() != null){
            expiration = jws.getBody().getExpiration().toInstant();
        }

        Instant issuedAt = LocalDateTime.now().toInstant(ZoneId.systemDefault().getRules().getOffset(LocalDateTime.now()));
        if (jws.getBody().getIssuedAt() != null) {
            issuedAt = jws.getBody().getIssuedAt().toInstant();
        }
        Jwt jwt = new Jwt(token,issuedAt,expiration,headers,claims);
        return jwt;
    }
}
