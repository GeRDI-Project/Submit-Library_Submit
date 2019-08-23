package org.gerdi.submit.security;

import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenProvider.class);

    private static final String AUTHORITIES_KEY = "auth";

    private JwkProvider provider = new UrlJwkProvider(new URL("https://www.test.gerdi.org/admin/auth/realms/master/protocol/openid-connect/certs"));

    public TokenProvider() throws MalformedURLException {
    }

    public String createToken(Authentication authentication) {

//        String authorities = authentication.getAuthorities().stream().map(authority -> authority.getAuthority()).collect(Collectors.joining(","));
//
//        ZonedDateTime now = ZonedDateTime.now();
//        ZonedDateTime expirationDateTime = now.plus(this.tokenValidityInMilliSeconds, ChronoUnit.MILLIS);
//
//        Date issueDate = Date.from(now.toInstant());
//        Date expirationDate = Date.from(expirationDateTime.toInstant());
//
//        return Jwts.builder().setSubject(authentication.getName()).claim(AUTHORITIES_KEY, authorities)
//                .signWith(SignatureAlgorithm.HS512, this.secretKey).setIssuedAt(issueDate).setExpiration(expirationDate).compact();
        return null;
    }

    public Authentication getAuthentication(String token) {

        DecodedJWT decodedJWT = JWT.decode(token);
        String subject = decodedJWT.getSubject();
//        Claims claims = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
//
//        Collection<? extends GrantedAuthority> authorities = Arrays.asList(claims.get(AUTHORITIES_KEY).toString().split(",")).stream()
//                .map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
        final List<SimpleGrantedAuthority> auths = Arrays.asList(new SimpleGrantedAuthority("All"));
        User principal = new User(subject, "",  auths);

        return new UsernamePasswordAuthenticationToken(principal, "", auths);
    }

    public boolean validateToken(String authToken) {
        try {
            DecodedJWT decodedJWT = JWT.decode(authToken);
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) provider.get(decodedJWT.getKeyId()).getPublicKey(), null);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(authToken);
            return true;
        } catch (JWTVerificationException | JwkException exception){
            return false;
        }

//        try {
//            Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(authToken);
//            return true;
//        } catch (SignatureException e) {
//            LOGGER.info("Invalid JWT signature: " + e.getMessage());
//            LOGGER.debug("Exception " + e.getMessage(), e);
//            return false;
//        }
    }
}
