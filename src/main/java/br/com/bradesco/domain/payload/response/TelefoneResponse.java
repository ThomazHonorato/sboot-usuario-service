package br.com.bradesco.domain.payload.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder(builderMethodName = "TelefoneResponseBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneResponse {

    private UUID id_telefone;
    private String ddd;
    private String numero;

}
