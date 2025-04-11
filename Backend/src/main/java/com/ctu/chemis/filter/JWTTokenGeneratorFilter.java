package com.ctu.chemis.filter;

import com.ctu.chemis.Constant.ApplicationEnvironment;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            //if the authentication is successful, generate the JWT token
            //create the environment hold the secret key
            Environment env = getEnvironment();
            //get the secret value from the env
            String secret = env.getProperty(ApplicationEnvironment.JWT_SECRET_KEY, ApplicationEnvironment.JWT_SECRET_DEFAULT_VALUE);
            //create the secret key with secret value
            SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder()
                    .issuer("Chemis").subject("JWT TOKEN")
                    .claim("email", authentication.getName())
                    .claim("authority", authentication.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                    .issuedAt(new Date())
                    .expiration(new Date(new Date().getTime() + 30000000))
                    .signWith(secretKey).compact();
            response.setHeader(ApplicationEnvironment.JWT_HEADER, jwt);
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        // This filter shouldn't be executed for the login endpoint
        return !request //if the path is not /user then executed;
                .getServletPath() //give the current path by client application
                .equals("/user");
    }
}
