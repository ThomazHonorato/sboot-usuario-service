package br.com.bradesco.domain.payload.dto;

import lombok.Data;

@Data
public class EnderecoDTO {

    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;

}
