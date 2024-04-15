package br.com.bradesco.service;

import br.com.bradesco.domain.payload.request.EnderecoRequest;
import br.com.bradesco.domain.payload.response.EnderecoResponse;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {

    EnderecoResponse createEndereco(final EnderecoRequest enderecoRequest);

    EnderecoResponse updateEndereco(final UUID idEndereco, final EnderecoRequest enderecoRequest);

    List<EnderecoResponse> getAllEndereco();

    EnderecoResponse getEnderecoById(final UUID idEndereco);
}
