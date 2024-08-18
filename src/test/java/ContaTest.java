import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaTest {

    @Spy
    private Conta conta = new Conta(1_000);

    @Test
    void validarOrdemChamada(){

        conta.pagaBoleto(300);

        //Verifica se o metodo pagarBoleto segue a ordem que esta dentro do metodo
        //dentro da classe
        InOrder inOrder = Mockito.inOrder(conta);
        inOrder.verify(conta).pagaBoleto(300);
        inOrder.verify(conta).validaSaldo(300);
        inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviaCreditoParaEmissor(300);
    }

    @Test
    void validarQuantidadeChamadas() {
        conta.validaSaldo(300);
        conta.validaSaldo(500);
        conta.validaSaldo(600);

        // Testando quantas vezes o metodo validar saldo foi chamado
        // como consta acima foram 3 vezes
        Mockito.verify(conta, Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());
    }
}
