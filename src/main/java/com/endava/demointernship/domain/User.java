package com.endava.demointernship.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nickname;

	@ManyToMany
	private List<User> follows;

}
