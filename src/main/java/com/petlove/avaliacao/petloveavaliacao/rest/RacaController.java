package com.petlove.avaliacao.petloveavaliacao.rest;

import com.petlove.avaliacao.petloveavaliacao.vo.RacaVO;
import com.petlove.avaliacao.petloveavaliacao.service.RacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/raca")
public class RacaController {

    Logger logger = Logger.getLogger("RacaController");

    @Autowired
    private RacaService racaService;


    @GetMapping("/nome/{nome}")
    public ResponseEntity<RacaVO> buscaRacaPorNome(@PathVariable("nome") String nome){
        logger.info("Evento busca raca recebido: " + nome);
        return ResponseEntity.status(OK)
                .body(racaService.buscarPorNome(nome));
    }

    @PostMapping(value = "/inserir", produces = "application/json", consumes = "application/json")
    public ResponseEntity<RacaVO> getAgenda(@RequestBody RacaVO racaVO){
        logger.info("Evento cadastra raca recebido: " + racaVO.toString());
       return  ResponseEntity.status(CREATED)
               .body(racaService.inserir(racaVO));

    }


}
