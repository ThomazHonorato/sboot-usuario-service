package br.com.bradesco.domain.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @Schema(description = "Nome", example = "Jonatas")
    @NotBlank(message="Nome não pode estar em branco")
    private String nome;

    @Schema(description = "Sobrenome", example = "Pedroso")
    @NotBlank(message="Sobrenome não pode estar em branco")
    private String sobrenome;

    @Schema(description = "Email", example = "email@email.com")
    @NotBlank(message = "Email não pode estar em branco")
    private String email;

    @Schema(description = "Data de Nascimento", example = "1992-04-14T00:00:00")
    @NotNull(message = "Data não pode estar em branco")
    private LocalDateTime dataNascimento;

    @Schema(description = "CNPJ", example = "118827393")
    @NotBlank(message = "CNPJ não pode estar em branco")
    private String cnpj;

}
