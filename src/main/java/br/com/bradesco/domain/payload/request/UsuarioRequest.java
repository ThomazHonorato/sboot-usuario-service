package br.com.bradesco.domain.payload.request;

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

    private String nome;
    private String sobrenome;
    private String email;
    private LocalDateTime dataNascimento;
    private String cnpj;
}
