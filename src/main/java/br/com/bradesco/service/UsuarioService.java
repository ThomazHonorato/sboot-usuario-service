package br.com.bradesco.service;

import br.com.bradesco.domain.payload.request.UsuarioRequest;
import br.com.bradesco.domain.payload.response.UsuarioResponse;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    UsuarioResponse createUsuario(final UsuarioRequest usuarioRequest);

    UsuarioResponse updateUsuario(final UUID idUsuario, final UsuarioRequest usuarioRequest);

    List<UsuarioResponse> getAllUsuarios();

    UsuarioResponse getUsuarioById(final UUID idUsuario);

}
