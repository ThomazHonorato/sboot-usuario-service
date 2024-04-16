package br.com.bradesco.service;

import br.com.bradesco.domain.payload.request.TelefoneRequest;
import br.com.bradesco.domain.payload.response.TelefoneResponse;

import java.util.List;
import java.util.UUID;

public interface TelefoneService {

    TelefoneResponse createTelefone(final TelefoneRequest telefoneRequest);

    TelefoneResponse updateTelefone(final UUID idTelefone, final TelefoneRequest telefoneRequest);

     List<TelefoneResponse> getAllTelefone();

     TelefoneResponse getTelefoneById(final UUID idTelefone);

}
