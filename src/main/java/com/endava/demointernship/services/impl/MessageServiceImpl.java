package com.endava.demointernship.services.impl;

import com.endava.demointernship.domain.Message;
import com.endava.demointernship.domain.User;
import com.endava.demointernship.dtos.MessageDTO;
import com.endava.demointernship.exceptions.NotFoundException;
import com.endava.demointernship.exceptions.ValidationException;
import com.endava.demointernship.repositories.MessageRepository;
import com.endava.demointernship.repositories.UserRepository;
import com.endava.demointernship.services.MessageService;
import com.endava.demointernship.services.UserService;
import com.endava.demointernship.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

	private final UserRepository userRepository;

	private final MessageRepository messageRepository;

	@Override
	public MessageDTO createMessage(MessageDTO messageDTO) {
		if (messageDTO.getId() != null) {
			throw new ValidationException("Invalid field id");
		}
		if (messageDTO.getUser().getId() == null) {
			throw new ValidationException("User id is required");
		}
		Long userId = messageDTO.getUser().getId();
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new NotFoundException("User " + userId + " not found"));
		Message message = Utils.mapDTOToMessage(messageDTO);
		message.setUser(user);
		//message.setCreatedAt(LocalDateTime.now());
		Message savedMessage = messageRepository.save(message);
		return Utils.mapMessageToDTO(savedMessage);
	}

	@Override
	public void deleteMessage(long messageId) {
		messageRepository.deleteById(messageId);
	}

	@Override
	public List<MessageDTO> getUserMessages(Long userId) {
		return messageRepository.findMessageByUserId(userId).stream()
				.map(Utils::mapMessageToDTO)
				.collect(Collectors.toList());
	}
}
