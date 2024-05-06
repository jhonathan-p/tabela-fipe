package com.example.Tabela.FIPE.main;

import com.example.Tabela.FIPE.model.RAnos;
import com.example.Tabela.FIPE.model.RMarcas;
import com.example.Tabela.FIPE.model.RModelos;
import com.example.Tabela.FIPE.service.ConectaApi;
import com.example.Tabela.FIPE.service.ConverteDados;

import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ConectaApi conectaApi = new ConectaApi();
    private ConverteDados converteDados = new ConverteDados();
    private int opcao = 0;
    private String carroMotoCaminhao = "";
    private String marca = "";
    private String codVeiculo = "";
    private String endereco = "https://parallelum.com.br/fipe/api/v1/";
    private String json = "";

    public void run() {
        System.out.print("""
        
        !Falta implementar sistema para detecção de erros e fazer melhorias!

        Consultar Tabela FIPE.

        1 - Carros
        2 - Motos
        3 - Caminhões

        Opção:\s""");
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1: {
                carroMotoCaminhao = "carros";
                break;
            }
            case 2: {
                carroMotoCaminhao = "motos";
                break;
            }
            case 3: {
                carroMotoCaminhao = "caminhoes";
            }
        }
        scanner.nextLine();
        System.out.println();
        endereco += carroMotoCaminhao + "/marcas/";
        json = conectaApi.obterDados(endereco);
        RMarcas[] marcas = converteDados.converteDados(json, RMarcas[].class);
		for (RMarcas marca : marcas) {
			System.out.println(marca);
		}

		System.out.print("\nCódigo da marca: ");
		marca = scanner.nextLine();
        endereco += marca + "/modelos/";
        json = conectaApi.obterDados(endereco);
        RModelos modelos = converteDados.converteDados(json, RModelos.class);
        System.out.println();
        modelos.modelos().forEach(System.out::println);

        System.out.print("\nCódigo do veículo: ");
        codVeiculo = scanner.nextLine();
        endereco += codVeiculo + "/anos/";
        json = conectaApi.obterDados(endereco);
        RAnos[] anos = converteDados.converteDados(json, RAnos[].class);
        System.out.println();
        for (RAnos ano : anos) {
            String veiculo = conectaApi.obterDados(endereco + ano.codigo());
            System.out.println(veiculo);
        }


    }
}

