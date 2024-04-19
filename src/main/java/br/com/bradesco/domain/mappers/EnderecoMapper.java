package br.com.bradesco.domain.mappers;

import br.com.bradesco.domain.entity.Endereco;
import br.com.bradesco.domain.payload.request.EnderecoRequest;
import br.com.bradesco.domain.payload.response.EnderecoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "idEndereco", ignore = true)
    @Mapping(target = "usuario.idUsuario", source="idUsuario")
    Endereco toEntity(EnderecoRequest enderecoRequest);

    @Mapping(target="idEndereco", ignore=true)
    @Mapping(target = "usuario.idUsuario", source = "idUsuario")
    void toUpdateEntity(final EnderecoRequest enderecoRequest, @MappingTarget final Endereco endereco);

    @Mapping(target = "idUsuario", source = "usuario.idUsuario")
    EnderecoResponse toResponse(final Endereco endereco);

}
