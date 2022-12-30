package de.han.ekl.backend.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class JWTValidator {

    public boolean validateJWT(String jwt){
        Jws<Claims> jws;
        try{
         jws = Jwts.parserBuilder()
                 .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode("/UB0VoEUQn9ecTqPaE6XlbtpbsupRaAtifHXfxEFSDA=")))
                 .build()
                 .parseClaimsJws(jwt);
         return true;
        }catch(JwtException ex){
            log.warn("JWT invalid", ex);
            return false;
        }
    }

    public Claims readJWT(String jwt){
        Jws<Claims> jws;
        try{
            jws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode("/UB0VoEUQn9ecTqPaE6XlbtpbsupRaAtifHXfxEFSDA=")))
                    .build()
                    .parseClaimsJws(jwt);
         return jws.getBody();
        }catch(JwtException ex){
            log.warn("JWT invalid, Claims could not read", ex);
            return null;
        }
    }

}
