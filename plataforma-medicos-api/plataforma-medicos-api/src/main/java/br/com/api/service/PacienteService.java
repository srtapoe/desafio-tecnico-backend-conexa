package br.com.api.service;

import br.com.api.dto.PacienteDTO;
import br.com.api.entity.Paciente;
import br.com.api.repository.PacienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    public ResponseEntity<PacienteDTO> salvar(PacienteDTO pacienteDTO) {
        if (pacienteRepository.existsByCpf(pacienteDTO.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new PacienteDTO("CPF já cadastrado."));
        }

        Paciente paciente = new Paciente();
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setNome(pacienteDTO.getNome());

        paciente = pacienteRepository.save(paciente);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new PacienteDTO(paciente));
    }
}
