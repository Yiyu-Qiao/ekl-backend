package de.han.ekl.backend.token;

import de.han.ekl.backend.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.util.Assert;

import java.security.Key;

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
}
