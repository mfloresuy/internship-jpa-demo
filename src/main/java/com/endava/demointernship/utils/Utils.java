package com.endava.demointernship.utils;

import com.endava.demointernship.domain.Message;
import com.endava.demointernship.domain.User;
import com.endava.demointernship.dtos.MessageDTO;
import com.endava.demointernship.dtos.UserDTO;

public class Utils {

	public static UserDTO mapUserToDTO(User user) {
		final UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setNickname(user.getNickname());
		return userDTO;
	}

	public static User mapDTOToUser(UserDTO userDTO) {
		final User user = new User();
		user.setId(userDTO.getId());
		user.setNickname(userDTO.getNickname());
		return user;
	}

	public static MessageDTO mapMessageToDTO(Message message) {
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setMessage(message.getMessage());
		messageDTO.setUser(mapUserToDTO(message.getUser()));
		messageDTO.setCreatedAt(message.getCreatedAt());
		messageDTO.setId(message.getId());
		return messageDTO;
	}

	public static Message mapDTOToMessage(MessageDTO messageDTO) {
		Message message = new Message();
		message.setMessage(messageDTO.getMessage());
		message.setCreatedAt(messageDTO.getCreatedAt());
		message.setId(messageDTO.getId());
		return message;
	}
}
