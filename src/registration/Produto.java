package registration;

import registration.type.Perfume;
import registration.type.Roupa;

public abstract class Produto implements Perfume, Roupa {

    private int id;
    private String nomeProduto;
    private int quantidade = 0;
    private double valor;
    private String tipoProduto;
    private char tipoPublico;
    private String tamanhoRoupa;
    private String tipoPerfume;
    

    public Produto() {
    }

    public Produto(int id, String nomeProduto, int quantidade, double valor, int tipoProduto, char tipoPublico) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.tipoProduto = setTipoProduto(tipoProduto);
        this.tipoPublico = tipoPublico;
    }

    public Produto(int id, String nomeProduto, int quantidade, double valor, int tipoProduto, char tipoPublico, String tamanhoRoupa) {
        this(id, nomeProduto, quantidade, valor, tipoProduto, tipoPublico);
        this.tamanhoRoupa = tamanhoRoupa;
    }

    public Produto(int id, String nomeProduto, int quantidade, double valor, int tipoProduto, char tipoPublico, char tipoPerfume) {
        this(id, nomeProduto, quantidade, valor, tipoProduto, tipoPublico);
        this.tipoPerfume = setTipoPerfume(tipoPerfume);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public String setTipoProduto(int tipoProduto) {
        return this.tipoProduto = (tipoProduto == Perfume.tipo) ? Perfume.nome : Roupa.nome;
    }

    public char getPublico() {
        return tipoPublico;
    }

    public void setPublico(char tipoPublico) {
        this.tipoPublico = tipoPublico;
    }

    public void setTamanhoRoupa(String tamanhoRoupa) {
        this.tamanhoRoupa = tamanhoRoupa;   
    }
    
    public String getTamanhoRoupa() {
        return tamanhoRoupa;
    }

    public String setTipoPerfume(char tipoPerfume) {
        return this.tipoPerfume = (tipoPerfume == Perfume.tipoPerfume1) ? Perfume.suave : Perfume.forte;
    }

    public String getTipoPerfume() {
        return tipoPerfume;
    }
}
