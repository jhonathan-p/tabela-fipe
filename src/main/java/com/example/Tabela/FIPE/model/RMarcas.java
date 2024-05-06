package com.example.Tabela.FIPE.model;

public record RMarcas(String codigo, String nome) {
    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Nome: " + nome;
    }
}
