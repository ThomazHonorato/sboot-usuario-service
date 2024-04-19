package br.com.bradesco.domain.mappers;

import br.com.bradesco.domain.entity.Telefone;
import br.com.bradesco.domain.payload.request.TelefoneRequest;
import br.com.bradesco.domain.payload.response.TelefoneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {

    @Mapping(target = "idTelefone", ignore = true)
    @Mapping(target="usuario.idUsuario", source="idUsuario")
    Telefone toEntity(TelefoneRequest telefoneRequest);

    @Mapping(target="idTelefone", ignore=true)
    @Mapping(target = "usuario.idUsuario", source="idUsuario")
    void toUpdateEntity(final TelefoneRequest telefoneRequest, @MappingTarget final Telefone telefone);

    @Mapping(target = "idUsuario", source="usuario.idUsuario")
    TelefoneResponse toResponse(final Telefone telefone);

}
