package org.isdb.DoctorBackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.isdb.DoctorBackend.annotation.CurrentUser;
import org.isdb.DoctorBackend.dto.PasswordChangeRequest;
import org.isdb.DoctorBackend.dto.UserCreateRequest;
import org.isdb.DoctorBackend.dto.UserResponse;
import org.isdb.DoctorBackend.dto.UserUpdateRequest;
import org.isdb.DoctorBackend.model.User;
import org.isdb.DoctorBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	public UserDetails user(@CurrentUser UserDetails currentUser) {
		return currentUser;
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<UserResponse> getAllUsers() {
		return userService.getAllUsers().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or @userSecurity.hasUserId(authentication, #id)")
	public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
		return userService.getUserById(id).map(user -> ResponseEntity.ok(convertToDTO(user)))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/role/{role}")
	@PreAuthorize("hasRole('ADMIN')")
	public List<UserResponse> getUsersByRole(@PathVariable Role role) {
		return userService.getUsersByRole(role).stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
		User user = new User(userCreateRequest.usersname(), userCreateRequest.email(), userCreateRequest.password(),
				userCreateRequest.role(), userCreateRequest.address(), userCreateRequest.age(),
				userCreateRequest.gender(), userCreateRequest.phoneNumber());

		User createdUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(createdUser));
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or @userSecurity.hasUserId(authentication, #id)")
	public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,
			@Valid @RequestBody UserUpdateRequest userUpdateRequest) {
		try {
			User userDetails = new User();
			userDetails.setUsersName(userUpdateRequest.username());
			userDetails.setEmail(userUpdateRequest.email());
			userDetails.setGender(userUpdateRequest.gender());
			userDetails.setAge(userUpdateRequest.age());
			userDetails.setPhoneNumber(userUpdateRequest.phoneNumber());

			// Only admin can update roles
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
				userDetails.setRole(userUpdateRequest.role());
			}

			User updatedUser = userService.updateUser(id, userDetails);
			return ResponseEntity.ok(convertToDTO(updatedUser));
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		try {
			userService.deleteUser(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/me")
	public ResponseEntity<UserResponse> getCurrentUser(Authentication authentication) {
		User currentUser = userService.getCurrentUser(authentication);
		if (currentUser == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(convertToDTO(currentUser));
	}

	@PostMapping("/change-password")
	public ResponseEntity<?> changePassword(Authentication authentication,
			@Valid @RequestBody PasswordChangeRequest request) {
		try {
			User currentUser = userService.getCurrentUser(authentication);
			if (currentUser == null) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}

			userService.changePassword(currentUser.getId(), request.currentPassword(), request.newPassword());

			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	// Helper method to convert User entity to UserDTO
	private UserResponse convertToDTO(User user) {
		UserResponse dto = new UserResponse();
		dto.setId(user.getId());
		dto.setUsername(user.getUsersName());
		dto.setEmail(user.getEmail());
		dto.setRole(user.getRole());
		dto.setGender(user.getGender());
		dto.setAge(user.getAge());
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setCreatedAt(user.getCreatedAt());
		dto.setUpdatedAt(user.getUpdatedAt());
		return dto;
	}
}