package br.com.api.service;

import br.com.api.dto.PacienteDTO;
import br.com.api.entity.Paciente;
import br.com.api.repository.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    @Test
    void testSalvarPaciente_comCpfNaoCadastrado() {
        Paciente paciente = new Paciente("Sheldon Cooper", "740.583.250-46");
        PacienteDTO pacienteDTO = new PacienteDTO(paciente);

        when(pacienteRepository.existsByCpf(pacienteDTO.getCpf())).thenReturn(false);
        when(pacienteRepository.save(any(Paciente.class))).thenReturn(paciente);

        ResponseEntity<PacienteDTO> response = pacienteService.salvar(pacienteDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("740.583.250-46", response.getBody().getCpf());
        assertEquals("Sheldon Cooper", response.getBody().getNome());

        verify(pacienteRepository, times(1)).save(any(Paciente.class));
    }

    @Test
    void testSalvarPaciente_comCpfJaCadastrado() {
        Paciente paciente = new Paciente("Sheldon Cooper", "740.583.250-46");
        PacienteDTO pacienteDTO = new PacienteDTO(paciente);

        when(pacienteRepository.existsByCpf(pacienteDTO.getCpf())).thenReturn(true);

        ResponseEntity<PacienteDTO> response = pacienteService.salvar(pacienteDTO);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("CPF já cadastrado.", response.getBody().getNome());

        verify(pacienteRepository, never()).save(any(Paciente.class));
    }
}
