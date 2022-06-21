package com.endava.demointernship.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NICKNAME")
	private String nickname;

	@ManyToMany
	@JoinTable(
			name = "USER_FOLLOWS",
			joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "FOLLOW_USER_ID")
	)
	private List<User> follows;

}
