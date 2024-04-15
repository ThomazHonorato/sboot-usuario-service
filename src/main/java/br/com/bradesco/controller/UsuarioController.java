package br.com.bradesco.controller;

import br.com.bradesco.domain.payload.request.UsuarioRequest;
import br.com.bradesco.domain.payload.response.UsuarioResponse;
import br.com.bradesco.exceptions.UsuarioNotFoundException;
import br.com.bradesco.service.impl.UsuarioServiceImpl;
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
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;


    @Operation(
            summary = "Cadastra um usuario no sistema.",
            description = "Endpoint para cadastrar um usuario no sistema.")
    @ApiResponse(
            responseCode = "200",
            description = "Cadastro efetuado",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponse.class))
            }
    )
    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioResponse> createUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){

        return ResponseEntity.ok(usuarioService.createUsuario(usuarioRequest));
    }

    @Operation(
            summary = "Altera um usuario",
            description = "Endpoint para alterar um usuario cadastrado")
    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@PathVariable UUID idUsuario){
        UsuarioResponse usuarioResponse = usuarioService.getUsuarioById(idUsuario);
        if(usuarioResponse != null){
            return ResponseEntity.ok(usuarioResponse);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(
            summary = "Obtém uma lista de usuarios cadastrados",
            description = "Endpoint para listar todos os usuarios cadastrados")
    @ApiResponse(
            responseCode = "200",
            description = "Registros encontrados",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponse.class))
            }
    )
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getAllUsuarios(){
        List<UsuarioResponse> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(
            summary = "Obtém um usuario pelo ID",
            description = "Endpoint para buscar um usuario cadastrado pelo seu ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Registro encontrados",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponse.class))
            }
    )
    @ApiResponse(
            responseCode = "404",
            description = "Registro não encontrado",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioNotFoundException.class))
            }
    )
    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> updateUsuario(@PathVariable UUID idUsuario, @RequestBody @Valid UsuarioRequest usuarioRequest){
        return ResponseEntity.ok(usuarioService.updateUsuario(idUsuario,usuarioRequest));
    }
}
