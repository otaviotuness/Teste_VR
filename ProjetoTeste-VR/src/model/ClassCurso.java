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
public class ClassCurso {
   private int codigo;
   private String descricao;
   private double duracao;
   private String periodo;
   private int qtd_aluno;
   private double carga_hr;
   private int professor;
   
    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getDuracao() {
        return duracao;
    }

    public String getPeriodo() {
        return periodo;
    }

    public int getQtd_aluno() {
        return qtd_aluno;
    }

    public double getCarga_hr() {
        return carga_hr;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setQtd_aluno(int qtd_aluno) {
        this.qtd_aluno = qtd_aluno;
    }

    public void setCarga_hr(double carga_hr) {
        this.carga_hr = carga_hr;
    }
    
    @Override
    public String toString(){
        return getDescricao();
    }
   
}
