package com.endava.demointernship.controllers;

import com.endava.demointernship.dtos.UserDTO;
import com.endava.demointernship.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}

	@PostMapping()
	public UserDTO createUser(@RequestBody UserDTO user) {
		return userService.createUser(user);
	}

	@GetMapping("/{id}")
	public UserDTO getUser(@PathVariable("id") long id) {
		return userService.getUser(id);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
	}

	@GetMapping("/{id}/follows")
	public List<UserDTO> followUser(@PathVariable long id) {
		return userService.getFollows(id);
	}

	@PostMapping("/{id}/follows/{followId}")
	public List<UserDTO> followUser(@PathVariable long id, @PathVariable("followId") long followId) {
		return userService.followUser(id, followId);
	}
}
