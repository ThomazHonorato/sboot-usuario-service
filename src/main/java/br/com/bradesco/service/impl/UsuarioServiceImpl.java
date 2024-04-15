package br.com.bradesco.service.impl;

import br.com.bradesco.domain.entity.Usuario;
import br.com.bradesco.domain.mappers.UsuarioMapper;
import br.com.bradesco.domain.payload.request.UsuarioRequest;
import br.com.bradesco.domain.payload.response.UsuarioResponse;
import br.com.bradesco.repository.UsuarioRepository;
import br.com.bradesco.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponse createUsuario(final UsuarioRequest usuarioRequest) {
        return usuarioMapper.toResponse(usuarioRepository.save(usuarioMapper.toEntity(usuarioRequest)));
    }

    @Override
    public UsuarioResponse updateUsuario(final UUID idUsuario, final UsuarioRequest usuarioRequest) {
        Usuario usuario = getUsuario(idUsuario);
        usuarioMapper.toUpdateEntity(usuarioRequest, usuario);
        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    @Override
    public List<UsuarioResponse> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuarioMapper::toResponse).toList();
    }

    @Override
    public UsuarioResponse getUsuarioById(final UUID idUsuario) {
        return usuarioMapper.toResponse(getUsuario(idUsuario));
    }

    //método deletar usuario

    private Usuario getUsuario(UUID idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow();
    }
}
