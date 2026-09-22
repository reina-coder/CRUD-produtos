package br.com.reina.produtos.controller;

import br.com.reina.produtos.service.ProdutoService;

import java.util.Scanner;
public class ProdutoController{
    ProdutoService produtoService = new ProdutoService();
    Scanner leitura = new Scanner(System.in);

    int resposta = 1;

    public void menu(){
        while (resposta != 0){

            System.out.println("╔══════════════════════════════╗\n" +
                               "║      SISTEMA DE PRODUTOS     ║\n" +
                               "╠══════════════════════════════╣\n" +
                               "║  1 - Cadastrar produto       ║\n" +
                               "║  2 - Listar produtos         ║\n" +
                               "║  3 - Buscar produto          ║\n" +
                               "║  4 - Atualizar produto       ║\n" +
                               "║  5 - Remover produto         ║\n" +
                               "║  0 - Sair                    ║\n" +
                               "╚══════════════════════════════╝\n");
            System.out.println("Digite o numero de acordo com a tabela: ");
            resposta = Integer.parseInt(leitura.nextLine());

            switch (resposta){
                case 1:
                    produtoService.cadastro();
                    break;
                case 2:
                    produtoService.listar();
                    break;
                case 3:
                    produtoService.buscar();
                    break;
                case 4:
                    produtoService.atualizar();
                    break;
                case 5:
                    produtoService.deletar();
                    break;
                case 0:
                    System.out.println("Pagina de cadastro finalizada");
                    break;
            }

        }
    }
}
