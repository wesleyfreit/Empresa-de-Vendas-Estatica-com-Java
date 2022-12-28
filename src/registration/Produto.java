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

    public Produto(int id, String nomeProduto, int quantidade, double valor, String tipoProduto, char tipoPublico) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.tipoProduto = tipoProduto;
        this.tipoPublico = tipoPublico;
    }

    public Produto(int id, String nomeProduto, int quantidade, double valor, String tipoProduto, char tipoPublico, String tipoTamanho) {
        this(id, nomeProduto, quantidade, valor, tipoProduto, tipoPublico);
        if(tipoProduto == Roupa.nome){
            this.tamanhoRoupa = tipoTamanho;
        } else {
            this.tipoPerfume = tipoTamanho;
        }
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
        if(tipoProduto == Perfume.tipo || tipoProduto == Roupa.tipo){
            return this.tipoProduto = (tipoProduto == Perfume.tipo) ? Perfume.nome : Roupa.nome;
        }   
        return null;
    }

    public char getPublico() {
        return tipoPublico;
    }

    public void setPublico(char tipoPublico) {
        this.tipoPublico = tipoPublico;
    }

    public String setTamanhoRoupa(String tamanhoRoupa) {
        for(String tamanho : Roupa.tamanhos){
            if(tamanho.equalsIgnoreCase(tamanhoRoupa)){
                return tamanho;
            }
        }
        return null;
    }
    
    public String getTamanhoRoupa() {
        return tamanhoRoupa;
    }

    public void getTamanhosRoupa() {
        for(String tamanho : Roupa.tamanhos){
            System.out.println(tamanho);
        }
    }

    public String setTipoPerfume(Character tipoPerfume) {
        for(int n = 0; n < Perfume.tipos.length; n++){
            if(Perfume.tipos[n].equals(tipoPerfume)){
                return Perfume.tiposFull[n];
            }
        }
        return null;
    }

    public String getTipoPerfume() {
        return tipoPerfume;
    }

    public void getTiposPerfume(){
        for(int n = 0; n < Perfume.tipos.length; n++){
            System.out.println(Perfume.tipos[n] + " - " + Perfume.tiposFull[n]);
        }
    } 
}
