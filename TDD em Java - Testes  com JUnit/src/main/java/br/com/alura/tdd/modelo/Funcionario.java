package br.com.alura.tdd.modelo;

import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private Double salario;

	public Funcionario(String nome, LocalDate dataAdmissao, Double salario) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public Double getSalario() {
		return salario;
	}

	//Método responsável por aumentar o salário
	public void reajustarSalario(Double salarioReajustado) {
		this.salario = this.salario + salarioReajustado;
	}
}
