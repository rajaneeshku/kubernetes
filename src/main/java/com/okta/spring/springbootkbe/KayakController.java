package com.okta.spring.springbootkbe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(path = "/kayaks")
public class KayakController {
    private final KayakRepository kayakRepository;
    public KayakController(KayakRepository kayakRepository){
        this.kayakRepository=kayakRepository;
    }
    @GetMapping()
    public @ResponseBody Flux<Kayak> getAllKayaks(){
        Flux<Kayak> result = kayakRepository.findAll();
        return result;
    }
    @PostMapping()
    public @ResponseBody Mono<Kayak> saveKayak(@RequestBody Kayak kayak){
        return kayakRepository.save(kayak);

    }
}
