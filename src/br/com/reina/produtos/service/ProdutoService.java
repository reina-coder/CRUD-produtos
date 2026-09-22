package br.com.reina.produtos.service;

import java.util.Scanner;
import br.com.reina.produtos.model.Produto;
import br.com.reina.produtos.repository.ProdutoRepository;

public class ProdutoService extends ProdutoRepository{
    Scanner leitura = new Scanner(System.in);

    public void cadastro(){

        Produto novoProduto = new Produto();

        System.out.println("Digite o nome do produto: ");
         novoProduto.setNome(leitura.nextLine());

        System.out.println("Digite o preco deste produto: ");
        novoProduto.setPreco(Double.parseDouble(leitura.nextLine()));

        System.out.println("Digite a quantidade em estoque deste produto: ");
        novoProduto.setQuantidade(Integer.parseInt(leitura.nextLine()));


        getListaProdutos().add(novoProduto);
        //salva para o meu json
        salvar();

        System.out.println("Produto Cadastrado com sucesso!!");
    }

    public void listar(){
        if(getListaProdutos().isEmpty()){
            System.out.println("Nenhum produto cadastrado ainda");
        }else{
            System.out.println(getListaProdutos());
        }
    }

    public void buscar(){
        System.out.println("Digite o nome do produto que deseja visualizar: ");
        String busca = leitura.nextLine();
        boolean encontrado = false;

        for(Produto produto : getListaProdutos()){
            if(produto.getNome().equalsIgnoreCase(busca)){
                System.out.println("Produto encontrado! ");
                System.out.println(produto);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Produto não  encontrado");
        }
    }

    public void atualizar(){
        System.out.println("Digite o nome do produto que deseja atuazalizar: ");
        String buscaAtualiza = leitura.nextLine();
        boolean encontrado = false;

        for(Produto produto : getListaProdutos()){
            if(produto.getNome().equalsIgnoreCase(buscaAtualiza)){
                encontrado = true;
                System.out.println("Digite o nome atualizado: ");
                produto.setNome(leitura.nextLine());

                System.out.println("Digite o preco atualizado: ");
                produto.setPreco(Double.parseDouble(leitura.nextLine()));

                System.out.println("Digite a quantidade atualizada: ");
                produto.setQuantidade(Integer.parseInt(leitura.nextLine()));

                //salva para o meu json.
                salvar();

                System.out.println("Dados do produto atualizado com sucesso!");
            }
        }
        if(!encontrado){
            System.out.println("Produto não encontrado");
        }
    }

    public void deletar(){
        System.out.println("Digite o nome do produto que deseja deletar: ");
        String buscaExcluir = leitura.nextLine();

        boolean removido = getListaProdutos().removeIf( produto  -> produto.getNome().equalsIgnoreCase(buscaExcluir));

        if(removido){
            //salva para o meu json
            salvar();
            System.out.println("Produto removido com sucesso!");
        }else{
            System.out.println("Produto não encontrado");
        }
    }

}
