package br.com.bradesco.domain.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest{

    @Schema(description = "Rua", example = "Rua joaquim da silva martha")
    @NotBlank(message = "Rua não pode estar vazio")
    private String rua;

    @Schema(description = "Numero", example = "1685")
    @NotBlank(message = "Numero não pode estar vazio")
    private String numero;

    @Schema(description = "Bairro", example = "Centro")
    @NotBlank(message = "Bairro não pode estar vazio")
    private String bairro;

    @Schema(description = "CEP", example = "17123112")
    @NotBlank(message = "CEP não pode estar vazio")
    private String cep;

    @Schema(description = "Cidade", example = "Bauru")
    @NotBlank(message = "Cidade não pode estar vazio")
    private String cidade;

    @Schema(description = "UF", example = "São Paulo")
    @NotBlank(message = "UF não pode estar vazio")
    private String uf;

    @Schema(description = "Id Relacionamento usuario", example = "2322-AC")
    private UUID idUsuario;

}
