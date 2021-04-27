import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Nesta classe estamos testando se o salario do funcionario está apto a receber o bonus
 * o valor do bonus (10%) não pode superar 1000, logo o valor do salario não pode ser maior
 * que 10 mil, se for, o bonuns não deve ser pago ao funcionário.
 */
public class BonusServiceTest {

    /**
     * Neste método estamos testando uma exceção, se ela está acontecendo na chamada do método
     */
    @Test
    public void bonusDeveSerZeroParaFuncionarioComSalarioAlto() {
        BonusService bonus = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> bonus.calcularBonus(new Funcionario("Diego", LocalDate.now(), 25000.0)));
    }

    /**
     * Neste método estamos testando um método (calcularBonus) que devolve um valor (Double)
     * fazemos o assertEquals em cima do valor do retorno do método e ele verifica se
     * o valor do retorno está de acordo com o esperado.
     */
    @Test
    public void bonusDeveSerDezPorCentoDoSalario() {
        BonusService bonus = new BonusService();
        //When
        Double calcBonus = bonus.calcularBonus(new Funcionario("Diego", LocalDate.now(), 2500.0));
        //Then
        assertEquals(250.0, calcBonus);
    }

    @Test
    public void bonusDeveraSerDezPorCentoParaSalarioAteDezMil() {
        BonusService bonus = new BonusService();
        //WHen
        Double calcBonus = bonus.calcularBonus(new Funcionario("Diego", LocalDate.now(), 10000.0));
        //Then
        assertEquals(1000.0, calcBonus);
    }
}