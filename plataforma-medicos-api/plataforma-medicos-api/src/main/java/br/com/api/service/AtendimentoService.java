package br.com.api.service;

import br.com.api.dto.AtendimentoDTO;
import br.com.api.entity.Atendimento;
import br.com.api.entity.Medico;
import br.com.api.entity.Paciente;
import br.com.api.exception.AgendamentoForaDasNormasException;
import br.com.api.exception.MedicoNaoEncontradoException;
import br.com.api.repository.AtendimentoRepository;
import br.com.api.repository.MedicoRepository;
import br.com.api.security.JwtUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    private final JwtUtil jwtUtil;

    private  final MedicoRepository medicoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository, JwtUtil jwtUtil, MedicoRepository medicoRepository) {
        this.atendimentoRepository = atendimentoRepository;
        this.jwtUtil = jwtUtil;
        this.medicoRepository = medicoRepository;
    }

    public void criarAtendimento(AtendimentoDTO atendimentoDTO, String token) throws MedicoNaoEncontradoException, AgendamentoForaDasNormasException {
        // Validar se a data é no futuro
        LocalDateTime dataHora = LocalDateTime.parse(atendimentoDTO.dataHora(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if (dataHora.isBefore(LocalDateTime.now())) {
            throw new AgendamentoForaDasNormasException("Agendamentos só podem ser criados para o futuro.");
        }

        // Recuperar o médico logado
        String email = jwtUtil.validateToken(token);
        Medico medico = medicoRepository.findByEmail(email)
                .orElseThrow(() -> new MedicoNaoEncontradoException("Médico não encontrado."));

        // Criar o atendimento
        Atendimento atendimento = new Atendimento();
        atendimento.setDataHora(dataHora);
        atendimento.setPaciente(new Paciente(atendimentoDTO.paciente().getNome(), atendimentoDTO.paciente().getCpf()));
        atendimento.setMedico(medico);

        atendimentoRepository.save(atendimento);
    }
}
