package org.isdb.DoctorBackend.controller;

import java.util.HashMap;
import java.util.Map;

import org.isdb.DoctorBackend.config.JwtTokenProvider;
import org.isdb.DoctorBackend.dto.LoginRequest;
import org.isdb.DoctorBackend.dto.RegisterRequest;
import org.isdb.DoctorBackend.dto.UserResponse;
import org.isdb.DoctorBackend.model.User;
import org.isdb.DoctorBackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
			UserService userService, PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
		try {
			User user = new User();
			user.setEmail(registerRequest.email());
			user.setFirstName(registerRequest.firstName());
			user.setLastName(registerRequest.lastName());
			user.setAge(registerRequest.age());
			user.setRole(registerRequest.role());
			String encode = passwordEncoder.encode(registerRequest.password().trim());
			System.out.println("Password is [" + encode + "]");
			user.setPassword(encode);
			user.setGender(registerRequest.gender());
			user.setPhoneNumber(registerRequest.phoneNumber());

			User savedUser = userService.createUser(user);

			UserResponse userResponse = new UserResponse();
			userResponse.setId(savedUser.getId());
			userResponse.setEmail(savedUser.getEmail());
			userResponse.setRole(savedUser.getRole());
			userResponse.setGender(savedUser.getGender());
			userResponse.setAge(savedUser.getAge());
			userResponse.setPhoneNumber(savedUser.getPhoneNumber());
			userResponse.setCreatedAt(savedUser.getCreatedAt());
			userResponse.setUpdatedAt(savedUser.getUpdatedAt());

			return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(HttpServletRequest request, HttpServletResponse response,
			@Valid @RequestBody LoginRequest loginRequest) {
		System.out.println("Check");
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtTokenProvider.createToken(authentication);

		Map<String, Object> responseData = new HashMap<>();
		responseData.put("tokenType", "Bearer");
		responseData.put("access_token", jwt);

		return ResponseEntity.ok(responseData);
	}

}