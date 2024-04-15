package br.com.bradesco.domain.mappers;

import br.com.bradesco.domain.entity.Endereco;
import br.com.bradesco.domain.payload.request.EnderecoRequest;
import br.com.bradesco.domain.payload.response.EnderecoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    Endereco toEntity(EnderecoRequest enderecoRequest);

    @Mapping(target="idEndereco", ignore=true)
    void toUpdateEntity(final EnderecoRequest enderecoRequest, @MappingTarget final Endereco endereco);

    EnderecoResponse toResponse(final Endereco endereco);

}
