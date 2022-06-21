package com.endava.demointernship.repositories;

import com.endava.demointernship.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
