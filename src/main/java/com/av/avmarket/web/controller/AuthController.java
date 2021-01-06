package com.av.avmarket.web.controller;

import com.av.avmarket.domain.dto.AuthenticationRequest;
import com.av.avmarket.domain.dto.AuthenticationResponse;
import com.av.avmarket.domain.service.AvUserDetailsService;
import com.av.avmarket.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private AvUserDetailsService avUserDetailsService;

  @Autowired
  private JWTUtil jwtUtil;

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {

    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
      UserDetails userDetails = avUserDetailsService.loadUserByUsername(request.getUserName());
      String jwt = jwtUtil.generateToken(userDetails);

      return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
    } catch (BadCredentialsException e) {
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
  }
}
