package br.com.bradesco.domain.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest extends UsuarioRequest{
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
}
