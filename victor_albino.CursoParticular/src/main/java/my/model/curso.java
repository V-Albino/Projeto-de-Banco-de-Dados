/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.model;

/**
 *
 * @author Acer
 */
public class curso {
    private String endereco;
    private int salas;
    private String preco;
    private String nome;

    public curso() {
        this.endereco = "";
        this.salas = 0;
        this.preco = ""; 
        this.nome = "";
    }

    public curso(String endereco, int salas, String preco, String nome) {
        this.endereco = endereco;
        this.salas = salas;
        this.preco = preco;
        this.nome = nome;
    }   

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getSalas() {
        return salas;
    }

    public void setSalas(int salas) {
        this.salas = salas;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
    return "{" + ", endereco=" + endereco + ", salas=" + salas + ", preco=" + preco + ", nome=" + nome +'}';
    }
    
}
