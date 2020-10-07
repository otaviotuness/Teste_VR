/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Otavio
 */
public class ClassDisciplina {
    
    private int codigo;
    private String descricao;
    private String ementa;
    private int limite_vaga;
    private int professor;
    private String dia_semana;
    private Double carga_hr;
    private String periodo;

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmenta() {
        return ementa;
    }

    public int getLimite_vaga() {
        return limite_vaga;
    }

    public int getProfessor() {
        return professor;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public Double getCarga_hr() {
        return carga_hr;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public void setLimite_vaga(int limite_vaga) {
        this.limite_vaga = limite_vaga;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public void setCarga_hr(Double carga_hr) {
        this.carga_hr = carga_hr;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
  
    
    
    
}
