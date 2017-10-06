package ar.com.onready.tuto.repository;

import ar.com.onready.tuto.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findById(int id);
}
