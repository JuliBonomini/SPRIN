package ar.com.onready.tuto.service;

import ar.com.onready.tuto.domain.User;

public interface UserService {

    User buscarPorUsername(String username);

    User buscarPorId(int id);

    User guardarUsuario(User user);
}
