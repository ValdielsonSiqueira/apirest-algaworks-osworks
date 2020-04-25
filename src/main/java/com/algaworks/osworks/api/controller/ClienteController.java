package com.algaworks.osworks.api.controller;

import com.algaworks.osworks.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @PersistenceContext
    public EntityManager manager;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return  manager.createQuery("from Cliente", Cliente.class)
                .getResultList();
    }
}
