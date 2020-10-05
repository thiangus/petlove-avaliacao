package com.petlove.avaliacao.petloveavaliacao.service.impl;

import com.petlove.avaliacao.petloveavaliacao.vo.RacaVO;
import com.petlove.avaliacao.petloveavaliacao.model.Raca;
import com.petlove.avaliacao.petloveavaliacao.respository.RacaRepository;
import com.petlove.avaliacao.petloveavaliacao.service.RacaService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RacaServiceImpl implements RacaService {

    Logger logger = Logger.getLogger("RacaServiceImpl");

    @Autowired
    private RacaRepository racaRepository;

    @Override
    public RacaVO inserir(RacaVO racaVO) {
        Raca raca = new Raca();
        raca.setNome(racaVO.getNome());
        val racaSaved = racaRepository.save(raca);

        logger.info("Raca salva com sucesso" + racaSaved);
        return RacaVO.builder()
                .code(racaSaved.getId())
                .nome(racaSaved.getNome())
                .build();
    }

    @Override
    public RacaVO buscarPorNome(String nome) {
        Optional<Raca> raca = racaRepository.findRacaByNome(nome);
        RacaVO.RacaVOBuilder racaVO = raca.map(r ->
                RacaVO.builder()
                        .nome(r.getNome())
                        .code(r.getId()))
                .orElse(RacaVO.builder().nome("Nao foi econtrado nenhuma raca com esse nome"));
        return racaVO.build();
    }
}
