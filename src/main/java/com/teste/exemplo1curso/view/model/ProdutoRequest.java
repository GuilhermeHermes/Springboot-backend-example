package com.teste.exemplo1curso.view.model;

public class ProdutoRequest {
   //OQ EU PRECISO NA HORA Q O USUARIO FIZERR O REQUEST.
    
    private String nome;
    
    private Integer quantidade;
    
    private Double valor;
    
    private String observacao;
    //#endregion
   
   //#region Getter e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
