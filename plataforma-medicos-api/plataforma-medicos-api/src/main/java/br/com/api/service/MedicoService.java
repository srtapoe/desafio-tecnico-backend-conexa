package br.com.api.service;


import br.com.api.dto.MedicoDTO;
import br.com.api.entity.Medico;
import br.com.api.enums.Role;
import br.com.api.exception.SenhasNaoConferemException;
import br.com.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void salvar(MedicoDTO medicoDTO) throws SenhasNaoConferemException {
        if (medicoRepository.existsByEmail(medicoDTO.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado!");
        }
        if (medicoRepository.existsByCpf(medicoDTO.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado!");
        }
        if(!medicoDTO.getPassword().equals(medicoDTO.getConfirmacaoPassword())){
           throw new SenhasNaoConferemException("As senhas não são iguais!");
       }

       Medico medico = new Medico();
       medico.setEmail(medicoDTO.getEmail());
       medico.setPassword(medicoDTO.getPassword());
       medico.setEspecialidade(medicoDTO.getEspecialidade());
       medico.setCpf(medicoDTO.getCpf());
       medico.setTelefone(medicoDTO.getTelefone());
       medico.setDataNascimento(LocalDate.parse(medicoDTO.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay());
       medico.setRole(Role.USER);

       medicoRepository.save(medico);
    }
}
