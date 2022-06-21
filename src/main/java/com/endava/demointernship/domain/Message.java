package com.endava.demointernship.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MESSAGES")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "MESSAGE")
	private String message;

	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;


	@Column(name = "CREATED_AT")
	@CreatedDate
	private LocalDateTime createdAt;
}
