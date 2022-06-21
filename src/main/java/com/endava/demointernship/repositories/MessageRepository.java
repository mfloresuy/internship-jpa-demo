package com.endava.demointernship.repositories;

import com.endava.demointernship.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findMessageByUserId(long userId);
}
