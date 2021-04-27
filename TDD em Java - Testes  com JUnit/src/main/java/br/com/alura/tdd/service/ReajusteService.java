package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

/**
 * Nesta classe estamos testando os métodos de reajuste salarial, onde as regras são:
 * Se o desempenho do funcionário for a desejar o aumento de seu salário será de 3%
 * Se o desempenho do funcionário for bom o aumento de seu salário será de 15%
 * Se o desempenho do funcionário for bom o aumento de seu salário será de 20%
 */
public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho){
        if (desempenho == Desempenho.A_DESEJAR){
            Double salarioReajustado = funcionario.getSalario() * 0.03;
            funcionario.reajustarSalario(salarioReajustado);
        }else if (desempenho == Desempenho.BOM){
            Double salarioReajustado = funcionario.getSalario() * 0.15;
            funcionario.reajustarSalario(salarioReajustado);
        }else {
            Double salarioReajustado = funcionario.getSalario() * 0.2;
            funcionario.reajustarSalario(salarioReajustado);
        }
    }

}
