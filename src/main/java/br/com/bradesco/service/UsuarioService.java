package br.com.bradesco.service;

import br.com.bradesco.domain.mappers.UsuarioMapper;
import br.com.bradesco.domain.payload.request.UsuarioRequest;
import br.com.bradesco.domain.payload.response.UsuarioResponse;
import br.com.bradesco.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    //método salvar
   public UsuarioResponse createUsuario(UsuarioRequest usuarioRequest){
        return usuarioMapper.toResponse(usuarioRepository.save(usuarioMapper.toEntity(usuarioRequest)));
    }

    //método alterar

    //método buscar

    //método buscar por id
   // public Usuario getUsuarioByID(UUID id_usuario){return usuarioRepository.findById(id_usuario).stream().findFirst().orElse(null);}

    //método deletar
}
