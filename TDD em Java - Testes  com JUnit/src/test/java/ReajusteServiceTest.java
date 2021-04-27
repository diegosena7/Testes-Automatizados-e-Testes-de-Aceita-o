import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    /**
     * Neste método estamos instanciando os objetos do tipo ReajusteService e Funcionario
     * com isso só utilizamos os atributos em nossos métodos.
     * Usamos a anotação @BeforeEach para que ele chame o método inicializar antes de inicializar
     * em todos os nossos testes.
     * Caso seja necessário poderíamos usa a anotação @AfterEach que vai fazer algo após o método
     * anotado seja chamado.
     */
    @BeforeEach
    public void inicializar(){
//        System.out.println("Inicializar...");
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Ryan", LocalDate.now(), 1000.0);
    }

//    @AfterEach
//    public void finalizar(){
//        System.out.println("Finalizar...");
//    }

    /**
     * Neste método estamos testando um método void, que não nos devolve nada e fazemos
     * mas modifica o valor contido no objeto recebido como parâmetro no método.
     * Fazemos o assertEquals em cima do objeto que passamos como parâmetro no método
     */
    @Test
    public void reajusteDeveSerDe3PorCentoParaDesempenhoADesejar(){
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(1030.0, funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDe15PorCentoParaDesempenhoBom(){
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(1150.0, funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDe20PorCentoParaDesempenhoOtimo(){
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(1200.0, funcionario.getSalario());
    }
}
