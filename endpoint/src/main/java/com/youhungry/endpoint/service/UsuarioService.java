package com.youhungry.endpoint.service;

import com.youhungry.endpoint.exceptions.UsuarioInvalidaException;
import com.youhungry.endpoint.model.Usuario;
import com.youhungry.endpoint.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioService {
    private static final UsuarioService INSTANCE = new UsuarioService();
    private UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    public Usuario createUsuario(Usuario usuario) {
        validarUsuario(usuario);
        if (usuarioRepository.getUsuarioById((usuario.getIdusuario())).isPresent()){
            throw new UsuarioInvalidaException(String.format("Já existe pessoa com o código %d", usuario.getIdusuario()));
        }

        return usuarioRepository.salvar(usuario);
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.getUsuarioById(id);
    }

    public Usuario updateUsuario(Usuario usuario) {
        validarUsuario(usuario);
        if (usuarioRepository.getUsuarioById(usuario.getIdusuario()).isPresent()) {
            throw new UsuarioInvalidaException(String.format("Não existe usuário com o código %d", usuario.getIdusuario()));
        }

        return usuarioRepository.salvar(usuario);
    }

    public void deleteUsuarioById(Long id) {
        usuarioRepository.deleteById(id);
    }

    private void validarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new UsuarioInvalidaException("O nome do usuário não foi informado");
        }
    }

    public static UsuarioService getInstance() {
        return INSTANCE;
    }

    public List<Usuario> todosUsuarios() {
        return usuarioRepository.todosUsuarios();
    }
}
