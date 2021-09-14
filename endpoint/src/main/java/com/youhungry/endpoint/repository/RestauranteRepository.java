package com.youhungry.endpoint.repository;

import com.youhungry.endpoint.model.Restaurante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RestauranteRepository {
    private static final RestauranteRepository INSTANCE = new RestauranteRepository();
    private static final Map<Long, Restaurante> restaurantes = new HashMap<>();

    public Restaurante salvar(Restaurante restaurante) {
        if (restaurantes.containsKey(restaurante.getIdrestaurante())) {
            restaurantes.replace(restaurante.getIdrestaurante(), restaurante);
        }

        restaurantes.put(restaurante.getIdrestaurante(), restaurante);
        return restaurante;
    }

    public Optional<Restaurante> getRestauranteById(Long id) {
        return Optional.ofNullable(restaurantes.get(id));
    }

    public static void deleteById(Long id) {
        restaurantes.remove(id);
    }

    public List<Restaurante> todosRestaurantes() {
        return restaurantes.values().stream().collect(Collectors.toList());
    }

    public static RestauranteRepository getInstance() {
        return INSTANCE;
    }
}
