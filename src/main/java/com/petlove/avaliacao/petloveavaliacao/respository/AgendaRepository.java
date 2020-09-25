package com.petlove.avaliacao.petloveavaliacao.respository;

import com.petlove.avaliacao.petloveavaliacao.model.Agenda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Long> {

    List<Agenda> findAll();


}
