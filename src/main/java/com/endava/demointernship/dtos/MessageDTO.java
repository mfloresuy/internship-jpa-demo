package com.endava.demointernship.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDTO {

	private Long id;

	private String message;

	private LocalDateTime createdAt;

	private UserDTO user;

}
