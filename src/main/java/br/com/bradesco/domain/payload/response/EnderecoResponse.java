package br.com.bradesco.domain.payload.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder(builderMethodName = "EnderecoResponseBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {

    private UUID id_endereco;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
}
