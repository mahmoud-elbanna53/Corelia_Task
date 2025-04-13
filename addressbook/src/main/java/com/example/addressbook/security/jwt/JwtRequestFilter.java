//package com.example.addressbook.security.jwt;
//
//import com.example.addressbook.appuser.AppUserService;
//import lombok.AllArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@AllArgsConstructor
//public class JwtRequestFilter extends OncePerRequestFilter{
//    private final JwtUtil jwtUtil;
//    private final AppUserService appUserService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        final String authorizationHeader = request.getHeader("Authorization");
//
//        String username = null;
//        String jwt = null;
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            jwt = authorizationHeader.substring(7);
//            username = jwtUtil.getUsernameFromToken(jwt);
//        }
//
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = this.appUserService.loadUserByUsername(username);
//
//            if (jwtUtil.validateToken(jwt, userDetails.getUsername())) {
//                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}
