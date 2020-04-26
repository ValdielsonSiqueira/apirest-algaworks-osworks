package com.algaworks.osworks.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionMessage {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    public static class Campo {

        private String nome;
        private String messagem;

        public Campo(String nome, String messagem) {
            this.nome = nome;
            this.messagem = messagem;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMessagem() {
            return messagem;
        }

        public void setMessagem(String messagem) {
            this.messagem = messagem;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
