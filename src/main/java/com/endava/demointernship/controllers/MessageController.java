package com.endava.demointernship.controllers;

import com.endava.demointernship.dtos.MessageDTO;
import com.endava.demointernship.dtos.UserDTO;
import com.endava.demointernship.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

	private final MessageService messageService;

	@PostMapping("/users/{userId}/messages")
	public MessageDTO createMessage(@PathVariable("userId") long userId, @RequestBody MessageDTO message) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userId);
		message.setUser(userDTO);
		return messageService.createMessage(message);
	}

	@GetMapping("/users/{userId}/messages")
	public List<MessageDTO> getMessages(@PathVariable("userId") long userId) {
		return messageService.getUserMessages(userId);
	}

	@GetMapping("/users/{userId}/feed")
	public List<MessageDTO> getFeed(@PathVariable("userId") long userId) {
		return messageService.getUserFeed(userId);
	}

	@DeleteMapping("/messages/{id}")
	public void deleteMessage(@PathVariable("id") long id) {
		messageService.deleteMessage(id);
	}
}
