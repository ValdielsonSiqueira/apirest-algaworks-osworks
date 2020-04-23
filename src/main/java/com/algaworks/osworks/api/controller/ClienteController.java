package com.algaworks.osworks.api.controller;

import com.algaworks.osworks.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Mariodo Mariodo");
        cliente1.setTelefone("48 9999-9999");
        cliente1.setEmail("mariodo@gmail.com");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Jonal");
        cliente2.setTelefone("48 9999-9999");
        cliente2.setEmail("jonal@gmail.com");

        return Arrays.asList(cliente1, cliente2);

    }
}
