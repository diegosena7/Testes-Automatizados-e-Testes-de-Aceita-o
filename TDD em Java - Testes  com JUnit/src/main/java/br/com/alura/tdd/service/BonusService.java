package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	/**
	 * Nesta classe calculamos o valor de um bonus ao funcionário, como regra o valor do bonus
	 * não pode superar 1000, caso supere o valor do bonus será 0.
	 * @param funcionario
	 * @return
	 */
	public Double calcularBonus(Funcionario funcionario) {
		Double valor = funcionario.getSalario() * 0.1;
		if (valor  > 1000.0) {
//			valor = 0.0;
			throw new IllegalArgumentException("Funcionário com salário superior a R$ 10.000,00 não pode receber bonificação.");
		}
		return valor;
	}
}
