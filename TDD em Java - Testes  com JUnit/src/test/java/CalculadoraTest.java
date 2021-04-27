import br.com.alura.tdd.modelo.Calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Nesta classe estamos testando os métodos da classe Calculadora
 * estamos utilizando JUnite em nossos testes anotando oe métodos
 * com o @Test
 * Utilizamos a classe Assert do JUnit para testar o retorno dos
 * nossos métodos de teste com o método assertEquals
 */
public class CalculadoraTest {

    @Test
    public void deveSomarDoisNumPositivos(){
        Calculadora cal = new Calculadora();
        int somar = cal.somar(3, 7);

        assertEquals(10, somar);
    }


    public void somaComNumNegativo(){

    }
}


