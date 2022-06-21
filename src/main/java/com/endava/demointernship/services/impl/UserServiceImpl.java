package com.endava.demointernship.services.impl;

import com.endava.demointernship.domain.User;
import com.endava.demointernship.dtos.UserDTO;
import com.endava.demointernship.exceptions.NotFoundException;
import com.endava.demointernship.exceptions.ValidationException;
import com.endava.demointernship.repositories.UserRepository;
import com.endava.demointernship.services.UserService;
import com.endava.demointernship.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		if (userDTO.getId() != null) {
			throw new ValidationException("Invalid field id");
		}
		return this.saveUser(userDTO);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		if (userDTO.getId() == null) {
			throw new ValidationException("Field id is required");
		}
		return this.saveUser(userDTO);
	}

	private UserDTO saveUser(UserDTO userDTO) {
		final User user = Utils.mapDTOToUser(userDTO);
		final User savedUser = this.userRepository.save(user);
		return Utils.mapUserToDTO(savedUser);
	}

	@Override
	public UserDTO getUser(Long id) {
		User user = findUser(id);
		return Utils.mapUserToDTO(user);
	}

	@Override
	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public List<UserDTO> getUsers() {
		return userRepository.findAll().stream()
				.map(Utils::mapUserToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<UserDTO> followUser(long id, long followId) {
		User user = findUser(id);
		User follow = findUser(followId);
		user.getFollows().add(follow);
		this.userRepository.save(user);
		return user.getFollows().stream().map(Utils::mapUserToDTO).collect(Collectors.toList());
	}

	@Override
	public List<UserDTO> getFollows(long id) {
		User user = findUser(id);
		return user.getFollows().stream().map(Utils::mapUserToDTO).collect(Collectors.toList());
	}

	private User findUser(Long id) {
		return this.userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User " + id + " not found"));
	}
}
