package com.petlove.avaliacao.petloveavaliacao.respository;

import com.petlove.avaliacao.petloveavaliacao.model.Proprietario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProprietarioRepository extends CrudRepository<Proprietario, Long> {

   List<Proprietario> findAll();
}
