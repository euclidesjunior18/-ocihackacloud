package com.youhungry.endpoint.repository;

import com.youhungry.endpoint.model.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioRepository {

    private static final UsuarioRepository INSTANCE = new UsuarioRepository();
    private static final Map<Long, Usuario> usuarios = new HashMap<>();

    public Usuario salvar(Usuario usuario) {
        if (usuarios.containsKey(usuario.getIdusuario())) {
            usuarios.replace(usuario.getIdusuario(), usuario);
        }

        usuarios.put(usuario.getIdusuario(), usuario);
        return usuario;
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    public static void deleteById(Long id) {
        usuarios.remove(id);
    }

    public List<Usuario> todosUsuarios() {
        return usuarios.values().stream().collect(Collectors.toList());
    }

    public static UsuarioRepository getInstance() {
        return INSTANCE;
    }
}
