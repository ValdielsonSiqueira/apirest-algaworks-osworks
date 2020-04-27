package com.algaworks.osworks.api.controller;

import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;
import com.algaworks.osworks.domain.service.GestaoOrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServico;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico){
        return gestaoOrdemServico.criar(ordemServico);
    }

    @GetMapping
    public List<OrdemServico> listar(){
        return ordemServicoRepository.findAll();
    }

    @GetMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServico> buscar(@PathVariable Long ordemServicoId){
        Optional<OrdemServico> ordemServico =  ordemServicoRepository.findById(ordemServicoId);

        if(ordemServico.isPresent()){
            return ResponseEntity.ok(ordemServico.get());
        }

        return ResponseEntity.notFound().build();
    }
}
