package br.com.bradesco.repository;

import br.com.bradesco.domain.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TelefoneRepository extends JpaRepository<Telefone, UUID> {
}
