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
public class professor {
    private String materia;
    private String salario; 
    private String CPF;
    private String nome;
    private String material;
    private String telefone;
    private String email;

    public professor() {
        this.materia = "";
        this.salario = "";
        this.CPF = "";
        this.nome = "";
        this.material = "";
        this.telefone = "";
        this.email = "";
    }

    public professor(String materia, String salario, String CPF, String nome, String material, String telefone, String email) {
        this.materia = materia;
        this.salario = salario;
        this.CPF = CPF;
        this.nome = nome;
        this.material = material;
        this.telefone = telefone;
        this.email = email;
    }
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
}