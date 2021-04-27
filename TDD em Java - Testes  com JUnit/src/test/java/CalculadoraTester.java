import br.com.alura.tdd.modelo.Calculadora;

/**
 * Nesta classe estamos realizando testes automatizados de forma errada, sem o uso do JUnit, por exemplo.
 */
public class CalculadoraTester {
    public static void main(String[] args) {

        Calculadora calculadoraTestes =  new Calculadora();

        int soma = calculadoraTestes.somar(3, 7);
        System.out.println("A soma é: " + soma);

        soma = calculadoraTestes.somar(1, 7);
        System.out.println("A soma é: " + soma);

        soma = calculadoraTestes.somar(-7, 7);
        System.out.println("A soma é: " + soma);

        soma = calculadoraTestes.somar(-10, 7);
        System.out.println("A soma é: " + soma);
    }
}
