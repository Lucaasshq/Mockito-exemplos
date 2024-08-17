
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTest {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;



    @Test
    void validaCadastrarPessoa() {
       DadosLocalizacao dadosFakes = new DadosLocalizacao("RN", "Natal", "Rua2", "casa", "Centro");

       Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("65535000")).thenReturn(dadosFakes);

        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Lucas", "8524545", LocalDate.now(), "65535000");

        assertEquals("Lucas", pessoa.getNome());
        assertEquals("8524545", pessoa.getDocumento());
        assertEquals("RN", pessoa.getEndereco().getUf() );
        assertEquals("casa", pessoa.getEndereco().getComplemento());

    }
}
