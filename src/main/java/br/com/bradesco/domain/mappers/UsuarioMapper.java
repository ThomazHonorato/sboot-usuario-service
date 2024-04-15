package br.com.bradesco.domain.mappers;

import br.com.bradesco.domain.entity.Usuario;
import br.com.bradesco.domain.payload.request.UsuarioRequest;
import br.com.bradesco.domain.payload.response.UsuarioResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {



    Usuario toEntity(UsuarioRequest usuarioRequest);



    UsuarioResponse toResponse(final Usuario usuario);


}
