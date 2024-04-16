package br.com.bradesco.controller;

import br.com.bradesco.domain.payload.request.TelefoneRequest;
import br.com.bradesco.domain.payload.response.TelefoneResponse;
import br.com.bradesco.exceptions.TelefoneNotFoundException;
import br.com.bradesco.service.impl.TelefoneServiceImpl;
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
@RequestMapping("/api/telefone")
public class TelefoneController {

    private final TelefoneServiceImpl telefoneServiceImpl;

    @Operation(
            summary = "Cadastra um telefone no sistema.",
            description = "Endpoint para cadastrar um telefone no sistema.")
    @ApiResponse(
            responseCode = "200",
            description = "Cadastro efetuado",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TelefoneResponse.class))
            }
    )
    @PostMapping("/cadastro")
    public ResponseEntity<TelefoneResponse> createTelefone(@RequestBody @Valid TelefoneRequest telefoneRequest) {
        return ResponseEntity.ok(telefoneServiceImpl.createTelefone(telefoneRequest));
    }

    @Operation(
            summary = "Altera um telefone",
            description = "Endpoint para alterar um telefone cadastrado")
    @PutMapping("/{idTelefone}")
    public ResponseEntity<TelefoneResponse> updateTelefone(@PathVariable UUID idTelefone, @RequestBody @Valid TelefoneRequest telefoneRequest) {
        return ResponseEntity.ok(telefoneServiceImpl.updateTelefone(idTelefone, telefoneRequest));
    }

    @Operation(
            summary = "Obtém uma lista de telefones cadastrados",
            description = "Endpoint para listar todos os telefones cadastrados")
    @ApiResponse(
            responseCode = "200",
            description = "Registros encontrados",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TelefoneResponse.class))
            }
    )
    @GetMapping
    public ResponseEntity<List<TelefoneResponse>> getAllTelefone() {
        List<TelefoneResponse> telefones = telefoneServiceImpl.getAllTelefone();
        return ResponseEntity.ok(telefones);
    }

    @Operation(
            summary = "Obtém um telefone pelo ID",
            description = "Endpoint para buscar um telefone cadastrado pelo seu ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Registro encontrados",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TelefoneResponse.class))
            }
    )
    @ApiResponse(
            responseCode = "404",
            description = "Registro não encontrado",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TelefoneNotFoundException.class))
            }
    )
    @GetMapping("{idTelefone}")
    public ResponseEntity<TelefoneResponse> getTelefoneById(@PathVariable UUID idTelefone) {
        TelefoneResponse telefoneResponse = telefoneServiceImpl.getTelefoneById(idTelefone);
        if (telefoneResponse != null) {
            return ResponseEntity.ok(telefoneResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
