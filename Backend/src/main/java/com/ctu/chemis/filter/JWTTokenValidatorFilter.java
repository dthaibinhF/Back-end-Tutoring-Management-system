package com.ctu.chemis.filter;

import com.ctu.chemis.Constant.ApplicationEnvironment;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JWTTokenValidatorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //get token from header
        String jwt = request.getHeader(ApplicationEnvironment.JWT_HEADER);
        if (jwt != null) {
            try {
                //get environment
                Environment env = getEnvironment();
                if (env != null) {
                    String secret= env.getProperty(ApplicationEnvironment.JWT_SECRET_KEY, ApplicationEnvironment.JWT_SECRET_DEFAULT_VALUE);
                    SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
                    if (secretKey != null) {
                        Claims claims = Jwts.parser().verifyWith(secretKey).build()
                                .parseSignedClaims(jwt).getPayload();
                        String email = claims.get("email", String.class);
                        String authorities = claims.get("authorities", String.class);
                        Authentication authentication = new UsernamePasswordAuthenticationToken(email, null,
                                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }catch (Exception e){
                throw new BadCredentialsException("Invalid token received");
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        // This filter shouldn't be executed for the login endpoint
        return request //if the path is not /user then executed;
                .getServletPath() //give the current path by client application
                .equals("/user");
    }
}
