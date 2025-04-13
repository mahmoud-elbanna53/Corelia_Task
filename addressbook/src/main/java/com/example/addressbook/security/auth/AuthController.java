//package com.example.addressbook.security.auth;
//
//import com.example.addressbook.security.jwt.JwtUtil;
//import com.example.addressbook.security.auth.requests.AuthenticationRequest;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//@AllArgsConstructor
//public class AuthController {
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//
//    @PostMapping("/login")
//    public ResponseEntity<Map<String, String>> authenticate(@RequestBody AuthenticationRequest request) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//        );
//
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        String token = jwtUtil.generateToken(userDetails, new HashMap<>());
//
//        Map<String, String> response = new HashMap<>();
//        response.put("token", token);
//
//        return ResponseEntity.ok(response);
//    }
//}
