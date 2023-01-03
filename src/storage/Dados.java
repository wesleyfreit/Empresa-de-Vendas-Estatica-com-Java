package storage;

import registration.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Dados extends Produto {

    private List<Produto> produtos = new ArrayList<>();

    public Dados() {
    }

    public Dados(int id, String nomeProduto, 
        int quantidade, double valor, 
        String tipoProduto, char publico) {

        super(id, nomeProduto, quantidade, 
        valor, tipoProduto, publico);
    }

    public Dados(int id, String nomeProduto, 
        int quantidade, double valor, 
        String tipoProduto, char publico, 
        String tipoTamanho) {

        super(id, nomeProduto, quantidade, valor, 
        tipoProduto, publico, tipoTamanho);
    }

    public void cadastroProduto(Produto prod) {
        produtos.add(prod);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public int sizeArray() {
        return produtos.size();
    }

    public int searchValues(int n) {
        int reg = 0;

        String tipo = setTipoProduto(n);

        for(Produto p : getProdutos()){
            if(p.getTipoProduto().equals(tipo)){
                reg++;
            }
        }
        return reg;
    }

    public List<Produto> busca(String nome) {
        return produtos.stream()
        .filter(p -> p.getNomeProduto()
        .toLowerCase().contains(nome))
        .collect(Collectors.toList());
    }

    public String busca(String nome, int n) {
        List<Produto> resultadoBusca = busca(nome);

        for(Produto p : resultadoBusca){
            if(p.getId() == n){
                return p.getNomeProduto();
            }
        }
        return null;
    }
}
