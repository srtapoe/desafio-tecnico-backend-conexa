package br.com.api.repository;

import br.com.api.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);}