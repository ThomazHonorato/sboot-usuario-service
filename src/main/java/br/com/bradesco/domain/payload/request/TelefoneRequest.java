package br.com.bradesco.domain.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneRequest extends UsuarioRequest{
    private String ddd;
    private String telefone;
}
