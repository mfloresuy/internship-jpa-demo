package com.endava.demointernship.repositories;

import com.endava.demointernship.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findMessageByUserId(long userId);

	@Query("SELECT m " +
			"FROM Message m " +
			"JOIN m.user author, " +
			"User user " +
			"WHERE user.id = :userId AND author MEMBER of user.follows")
	List<Message> findMessageFeed(long userId);
}
