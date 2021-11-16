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
public class aluno {
    public String nome;
    public String material;
    public String CPF;
    public String telefone;

    public aluno() {
        this.nome = "";
        this.material = "";
        this.CPF = "";
        this.telefone = "";
    }

    public aluno(String nome, String material, String CPF, String telefone) {
        this.nome = nome;
        this.material = material;
        this.CPF = CPF;
        this.telefone = telefone;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
