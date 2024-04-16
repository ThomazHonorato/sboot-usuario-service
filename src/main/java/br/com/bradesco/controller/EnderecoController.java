package br.com.bradesco.controller;

import br.com.bradesco.domain.payload.request.EnderecoRequest;
import br.com.bradesco.domain.payload.response.EnderecoResponse;
import br.com.bradesco.exceptions.EnderecoNotFoundException;
import br.com.bradesco.service.impl.EnderecoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final EnderecoServiceImpl enderecoServiceImpl;

    @Operation(
            summary = "Cadastra um endereço no sistema.",
            description = "Endpoint para cadastrar um endereço no sistema.")
    @ApiResponse(
            responseCode = "200",
            description = "Cadastro efetuado",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EnderecoResponse.class))
            }
    )
    @PostMapping("/cadastro")
    public ResponseEntity<EnderecoResponse> createEndereco(@RequestBody @Valid EnderecoRequest enderecoRequest) {
        return ResponseEntity.ok(enderecoServiceImpl.createEndereco(enderecoRequest));
    }

    @Operation(
            summary = "Altera um endereço",
            description = "Endpoint para alterar um endereço cadastrado")
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoResponse> updateEndereco(@PathVariable UUID idEndereco, @RequestBody @Valid EnderecoRequest enderecoRequest) {
        return ResponseEntity.ok(enderecoServiceImpl.updateEndereco(idEndereco, enderecoRequest));
    }

    @Operation(
            summary = "Obtém uma lista de endereços cadastrados",
            description = "Endpoint para listar todos os endereços cadastrados")
    @ApiResponse(
            responseCode = "200",
            description = "Registros encontrados",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EnderecoResponse.class))
            }
    )
    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> getAllTelefone() {
        List<EnderecoResponse> enderecos = enderecoServiceImpl.getAllEndereco();
        return ResponseEntity.ok(enderecos);
    }

    @Operation(
            summary = "Obtém um endereço pelo ID",
            description = "Endpoint para buscar um endereço cadastrado pelo seu ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Registro encontrados",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EnderecoResponse.class))
            }
    )
    @ApiResponse(
            responseCode = "404",
            description = "Registro não encontrado",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EnderecoNotFoundException.class))
            }
    )
    @GetMapping("{idEndereco}")
    public ResponseEntity<EnderecoResponse> getEnderecoById(@PathVariable UUID idEndereco) {
        EnderecoResponse enderecoResponse = enderecoServiceImpl.getEnderecoById(idEndereco);
        if (enderecoResponse != null) {
            return ResponseEntity.ok(enderecoResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
