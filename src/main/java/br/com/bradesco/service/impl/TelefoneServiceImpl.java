package br.com.bradesco.service.impl;

import br.com.bradesco.domain.entity.Telefone;
import br.com.bradesco.domain.mappers.TelefoneMapper;
import br.com.bradesco.domain.payload.request.TelefoneRequest;
import br.com.bradesco.domain.payload.response.TelefoneResponse;
import br.com.bradesco.exceptions.TelefoneNotFoundException;
import br.com.bradesco.repository.TelefoneRepository;
import br.com.bradesco.service.TelefoneService;
import br.com.bradesco.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TelefoneServiceImpl implements TelefoneService {

    private final UsuarioService usuarioService;
    private final TelefoneRepository telefoneRepository;
    private final TelefoneMapper telefoneMapper;

    @Override
    public TelefoneResponse createTelefone(final TelefoneRequest telefoneRequest){
        usuarioService.getUsuarioById(telefoneRequest.getIdUsuario());
        return telefoneMapper.toResponse(telefoneRepository.save(telefoneMapper.toEntity(telefoneRequest)));
    }

    @Override
    public TelefoneResponse updateTelefone(final UUID idTelefone, final TelefoneRequest telefoneRequest){
        Telefone telefone = getTelefone(idTelefone);

        if(telefoneRequest.getTelefone() != null){
            telefone.setTelefone(telefoneRequest.getTelefone());
        }

        if(telefoneRequest.getDdd() != null){
            telefone.setDdd(telefoneRequest.getDdd());
        }

        telefoneMapper.toUpdateEntity(telefoneRequest, telefone);
        return telefoneMapper.toResponse(telefoneRepository.save(telefone));
    }

    public List<TelefoneResponse> getAllTelefone(){
        List<Telefone> telefones = telefoneRepository.findAll();
        return telefones.stream().map(telefoneMapper::toResponse).toList();
    }

    public TelefoneResponse getTelefoneById(@PathVariable UUID idTelefone){
        return telefoneMapper.toResponse(getTelefone(idTelefone));
    }

    private Telefone getTelefone(UUID idTelefone) {
        return telefoneRepository.findById(idTelefone).orElseThrow(TelefoneNotFoundException::new);
    }

}
