package br.com.reina.produtos;

import br.com.reina.produtos.controller.ProdutoController;

public class MainProduto {
    public static void main(String[] args) {
        ProdutoController produto = new ProdutoController();

        produto.menu();
    }
}
