package com.endava.demointernship.services;

import com.endava.demointernship.dtos.MessageDTO;

import java.util.List;

public interface MessageService {

	MessageDTO createMessage(MessageDTO message);

	void deleteMessage(long messageId);

	List<MessageDTO> getUserMessages(Long userId);

	List<MessageDTO> getUserFeed(long userId);
}
