package br.com.reina.produtos.repository;

import br.com.reina.produtos.model.Produto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private List<Produto> listaProdutos = new ArrayList<>();
    private final String ARQUIVO = "produtos.json";
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


    public ProdutoRepository(){
        carregar();
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }


    public void salvar() {

        try (FileWriter escritor = new FileWriter(ARQUIVO)) {

            gson.toJson(listaProdutos, escritor);

        } catch (IOException e) {

            System.out.println("Erro ao salvar os produtos.");
        }
    }


    private void carregar() {

        try (FileReader leitor = new FileReader(ARQUIVO)) {

            Type tipoLista = new TypeToken<List<Produto>>(){}.getType();

            listaProdutos = gson.fromJson(leitor, tipoLista);

            if (listaProdutos == null) {
                listaProdutos = new ArrayList<>();
            }

        } catch (IOException e) {

            listaProdutos = new ArrayList<>();
        }
    }
}
