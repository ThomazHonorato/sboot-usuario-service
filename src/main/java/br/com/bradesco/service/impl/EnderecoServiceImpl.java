package br.com.bradesco.service.impl;

import br.com.bradesco.domain.entity.Endereco;
import br.com.bradesco.domain.mappers.EnderecoMapper;
import br.com.bradesco.domain.payload.request.EnderecoRequest;
import br.com.bradesco.domain.payload.response.EnderecoResponse;
import br.com.bradesco.repository.EnderecoRepository;
import br.com.bradesco.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoMapper enderecoMapper;

    @Override
    public EnderecoResponse createEndereco(final EnderecoRequest enderecoRequest){
        return enderecoMapper.toResponse(enderecoRepository.save(enderecoMapper.toEntity(enderecoRequest)));
    }

    @Override
    public EnderecoResponse updateEndereco(final UUID idEndereco, final EnderecoRequest enderecoRequest){
        Endereco endereco = getEndereco(idEndereco);

        enderecoMapper.toUpdateEntity(enderecoRequest, endereco);
        return enderecoMapper.toResponse(enderecoRepository.save(endereco));
    }

    public List<EnderecoResponse> getAllEndereco(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream().map(enderecoMapper::toResponse).toList();
    }

    public EnderecoResponse getEnderecoById(@PathVariable UUID idEndereco){
        return enderecoMapper.toResponse(getEndereco(idEndereco));
    }

    private Endereco getEndereco(UUID idEndereco) {
        return enderecoRepository.findById(idEndereco).orElseThrow();
    }
}
