package ar.com.onready.tuto.service.impl;

import ar.com.onready.tuto.domain.User;
import ar.com.onready.tuto.repository.UserRepository;
import ar.com.onready.tuto.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User buscarPorUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User buscarPorId(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User guardarUsuario(User user) {
        return userRepository.save(user);
    }
}
