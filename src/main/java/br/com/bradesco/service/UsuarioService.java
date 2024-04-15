package br.com.bradesco.service;

import br.com.bradesco.domain.entity.Usuario;
import br.com.bradesco.domain.mappers.UsuarioMapper;
import br.com.bradesco.domain.payload.request.UsuarioRequest;
import br.com.bradesco.domain.payload.response.UsuarioResponse;
import br.com.bradesco.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
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
    public UsuarioResponse updteUsuario(UUID idUsuario, UsuarioRequest usuarioRequest){
        Usuario usuario = getUsuario(idUsuario);
        return null;
    }

    //método buscar

    //método buscar por id
   //public Usuario getUsuarioById(UUID idUsuario){return usuarioMapper.toResponse(getUsuario(idUsuario));}

    //método deletar

    private Usuario getUsuario(UUID idUsuario){
       //return usuarioRepository.findById(idUsuario).orElseThrow();
        return null;
    }
}
