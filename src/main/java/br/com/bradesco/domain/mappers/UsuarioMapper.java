package br.com.bradesco.domain.mappers;

import br.com.bradesco.domain.entity.Usuario;
import br.com.bradesco.domain.payload.request.UsuarioRequest;
import br.com.bradesco.domain.payload.response.UsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioRequest usuarioRequest);

    @Mapping(target="idUsuario", ignore = true)
    void toUpdateEntity(final UsuarioRequest usuarioRequest, @MappingTarget final Usuario usuario);

    UsuarioResponse toResponse(final Usuario usuario);

}
