package com.endava.demointernship.services;

import com.endava.demointernship.dtos.UserDTO;

import java.util.List;

public interface UserService {

	UserDTO createUser(UserDTO userDTO);

	UserDTO updateUser(UserDTO userDTO);

	UserDTO getUser(Long id);

	void deleteUser(Long id);

	List<UserDTO> getUsers();

	List<UserDTO> followUser(long id, long followId);

	List<UserDTO> getFollows(long id);
}
