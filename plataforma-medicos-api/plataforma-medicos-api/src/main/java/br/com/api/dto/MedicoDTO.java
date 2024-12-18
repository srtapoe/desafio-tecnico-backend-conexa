package br.com.api.dto;

import br.com.api.enums.Especialidade;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {

    @Email(message = "O email é obrigatório")
    private String email;
    @NotBlank(message = "Campo senha é obrigatório")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String password;
    @NotBlank(message = "A confirmação da senha é obrigatório")
    private String confirmacaoPassword;
    @NotNull(message = "A especialidade é obrigatória")
    private Especialidade especialidade;
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido")
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;
    @NotNull(message = "A data de nascimento é obrigatória")
    private String dataNascimento;
    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Telefone inválido")
    private String telefone;
}
