package com.group3.backend.ui.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthorisationFilter extends BasicAuthenticationFilter {

    public AuthorisationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authHeader = request.getHeader(SecurityConstants.HEADER_STRING);
        if (authHeader == null || !authHeader.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request,response);
            return;
        }

        UsernamePasswordAuthenticationToken authToken = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.HEADER_STRING);
        token = token.split(" ")[1]; //split the token to get the second part. format of token = "Bearer asdas98djasjkdq"
        String user = Jwts.parser().setSigningKey(SecurityConstants.TOKEN_SECRET).parseClaimsJws(token).getBody().getSubject();
        if (user != null) {
            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        }
        return null;
    }

    public static JwtData decodeJwt(String token) {
        if (token.startsWith(SecurityConstants.TOKEN_PREFIX + " ")) {
            token = token.split(" ")[1];
        }
        Claims body = Jwts.parser().setSigningKey(SecurityConstants.TOKEN_SECRET).parseClaimsJws(token).getBody();
        return new JwtData(body.get("careHomeId", String.class), body.get("email", String.class));
    }
}
