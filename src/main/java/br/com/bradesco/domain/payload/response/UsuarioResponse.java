package br.com.bradesco.domain.payload.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder(builderMethodName = "UsuarioResponseBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private UUID idUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private LocalDateTime dataNascimento;
    private String cnpj;
}
