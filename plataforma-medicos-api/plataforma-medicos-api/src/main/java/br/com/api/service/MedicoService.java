package br.com.api.service;


import br.com.api.dto.MedicoDTO;
import br.com.api.dto.MedicoListaDTO;
import br.com.api.entity.Medico;
import br.com.api.exception.SenhasNaoConferemException;
import br.com.api.repository.MedicoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public MedicoService(MedicoRepository medicoRepository, BCryptPasswordEncoder passwordEncoder) {
        this.medicoRepository = medicoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void salvar(MedicoDTO medicoDTO) throws SenhasNaoConferemException {
        if (medicoRepository.existsByEmail(medicoDTO.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado!");
        }
        if (medicoRepository.existsByCpf(medicoDTO.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado!");
        }
        if(!medicoDTO.getSenha().equals(medicoDTO.getConfirmacaoSenha())){
           throw new SenhasNaoConferemException("As senhas não são iguais!");
       }

       Medico medico = new Medico();
       medico.setEmail(medicoDTO.getEmail());
       medico.setSenha(passwordEncoder.encode(medicoDTO.getSenha()));
       medico.setEspecialidade(medicoDTO.getEspecialidade());
       medico.setCpf(medicoDTO.getCpf());
       medico.setTelefone(medicoDTO.getTelefone());
       medico.setDataNascimento(LocalDate.parse(medicoDTO.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay());
       medico.setRole(medicoDTO.getRole());

       medicoRepository.save(medico);
    }

    public List<MedicoListaDTO> listar() {
        return medicoRepository.findAll().stream()
                .map(medico -> new MedicoListaDTO(
                        medico.getEmail(),
                        medico.getEspecialidade(),
                        medico.getCpf(),
                        medico.getDataNascimento().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        medico.getTelefone(),
                        medico.getRole()
                ))
                .collect(Collectors.toList());
    }
}
