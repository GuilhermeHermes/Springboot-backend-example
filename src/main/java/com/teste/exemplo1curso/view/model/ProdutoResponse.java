package com.teste.exemplo1curso.view.model;
//OQ EU VOU DEVOLVER APOS RECEBER O REQUEST
public class ProdutoResponse {
    private Integer id;
    
    private String nome;
    
    private Integer quantidade;
    
    private Double valor;
    
    
    //#endregion
   
   //#region Getter e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
