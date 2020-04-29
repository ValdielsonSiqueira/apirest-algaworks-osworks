package com.algaworks.osworks.api.model;

import com.algaworks.osworks.domain.model.OrdemServico;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OrdemServico ordemServico;
    private String descricao;
    private OffsetDateTime dataEnvio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public OffsetDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(OffsetDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
