package com.petlove.avaliacao.petloveavaliacao.respository;

import com.petlove.avaliacao.petloveavaliacao.model.Raca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RacaRepository extends CrudRepository<Raca, Long> {

    Optional<Raca> findRacaByNome(String nome);
}
