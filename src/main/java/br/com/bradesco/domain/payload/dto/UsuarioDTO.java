package br.com.bradesco.domain.payload.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private LocalDateTime dataNascimento;
    private String cnpj;

}
