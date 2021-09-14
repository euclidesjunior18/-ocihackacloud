package com.youhungry.endpoint.repository;

import com.youhungry.endpoint.model.Prato;
import com.youhungry.endpoint.model.Restaurante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PratoRepository {
    private static final PratoRepository INSTANCE = new PratoRepository();
    private static final Map<Long, Prato> pratos = new HashMap<>();

    public Prato salvar(Prato prato) {
        if (pratos.containsKey(prato.getIdprato())) {
            pratos.replace(prato.getIdprato(), prato);
        }

        pratos.put(prato.getIdprato(), prato);
        return prato;
    }

    public Optional<Prato> getPratoById(Long id) {
        return Optional.ofNullable(pratos.get(id));
    }

    public static void deleteById(Long id) {
        pratos.remove(id);
    }

    public List<Prato> todosPratos() {
        return pratos.values().stream().collect(Collectors.toList());
    }

    public static PratoRepository getInstance() {
        return INSTANCE;
    }
}
