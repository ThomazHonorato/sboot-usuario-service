package br.com.bradesco.domain.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioResponse {

    private UUID idUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private LocalDateTime dataNascimento;
    private String cnpj;

}
