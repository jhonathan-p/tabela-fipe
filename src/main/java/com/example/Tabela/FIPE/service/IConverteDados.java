package com.example.Tabela.FIPE.service;

public interface IConverteDados {
    <T> T converteDados(String json, Class<T> classe);
}