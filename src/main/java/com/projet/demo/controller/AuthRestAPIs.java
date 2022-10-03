package com.projet.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.demo.message.request.LoginForm;
import com.projet.demo.message.request.SignUpForm;
import com.projet.demo.message.response.AccountResponce;
import com.projet.demo.message.response.JwtResponse;
import com.projet.demo.model.User;
import com.projet.demo.repository.UserRepository;
import com.projet.demo.security.jwt.JwtProvider;
 

 

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@PostMapping("/signup")
	public AccountResponce registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
	
		AccountResponce accountResponce=new AccountResponce();
		Boolean result1=userRepository.existsByUsername(signUpRequest.getUsername());

		Boolean result=userRepository.existsByEmail(signUpRequest.getEmail());
		if(result || result1) {
			accountResponce.setResult(0);
		}else {

		// Creating user's account
		User userregister = new User();
		userregister.setNom(signUpRequest.getNom());
		userregister.setPrenom(signUpRequest.getPrenom());
		userregister.setUsername(signUpRequest.getUsername());
		
		userregister.setEmail(signUpRequest.getEmail());
		
		
	
		String roless=signUpRequest.getRole();
        
		 if(roless=="admin") {	 
			 userregister.setRoles("ROLE_ADMIN");
		 }else if (roless=="pm") {
			 userregister.setRoles("ROLE_PM");
		 }else {
			 userregister.setRoles("ROLE_USER");
		 }
		 
		 
		userregister.setPassword(encoder.encode(signUpRequest.getPassword()));

		userRepository.save(userregister);
		accountResponce.setResult(1);
		}
		return accountResponce;
	
		}
}