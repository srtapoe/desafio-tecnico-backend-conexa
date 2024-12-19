package br.com.api.service;

import br.com.api.dto.LoginDTO;
import br.com.api.entity.Medico;
import br.com.api.exception.SenhaIncorretaException;
import br.com.api.exception.UsuarioNaoEncontradoException;
import br.com.api.repository.MedicoRepository;
import br.com.api.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final MedicoRepository medicoRepository;

    private final JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(MedicoRepository medicoRepository, JwtUtil jwtUtil, BCryptPasswordEncoder passwordEncoder) {
        this.medicoRepository = medicoRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(LoginDTO loginDTO) throws UsuarioNaoEncontradoException, SenhaIncorretaException {
        Medico medico = medicoRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));

        if (!passwordEncoder.matches(loginDTO.getSenha(), medico.getPassword())) {
            throw new SenhaIncorretaException("Senha incorreta");
        }
        return jwtUtil.generateToken(medico.getEmail());
    }
}
