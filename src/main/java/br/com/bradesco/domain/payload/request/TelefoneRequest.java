package br.com.bradesco.domain.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneRequest {

    @Schema(description = "DDD", example = "21")
    @NotBlank(message="DDD não pode ser vazio")
    private String ddd;

    @Schema(description = "Telefone", example = "991184530")
    @NotBlank(message="Telefone não pode ser vazio")
    private String telefone;

    @Schema(description = "Id Relacionamento usuario", example = "2322-AC")
    private UUID idUsuario;

}
