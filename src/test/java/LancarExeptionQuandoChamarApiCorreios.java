import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class LancarExeptionQuandoChamarApiCorreios {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;


    @Test
    void lancarExeptionQuandoChamarApiCorreios() {


        DadosLocalizacao dadosFakes = new DadosLocalizacao("RN", "Natal", "Rua2", "casa", "Centro");

        Mockito.doThrow(IllegalArgumentException.class)
                        .when(apiDosCorreios).buscaDadosComBaseNoCep(anyString());


        Assertions.assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("Lucas", "8524545", LocalDate.now(), "65535000"));
    }

    @Test
    void
}
