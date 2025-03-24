package com.ctu.chemis.filter;

import com.ctu.chemis.config.SecurityConfig;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 *  {@link CsrfTokenRepository} in {@link SecurityConfig} will never generate a new token unless something trying to read it.
 *  So when the UI expecting a token from a backend, it is never going to be generated automatically.
 *  This filter will read the token => {@link CsrfTokenRepository} generate token and stored in a cookie.
 *  This filter will be executed after the BasicAuthenticationFilter.
 * */
public class CsrfCookieFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName()); //get object of CSRF token
        // Render the token value to a cookie by causing the deferred token to be loaded
        csrfToken.getToken();
        filterChain.doFilter(request, response);
    }
}
