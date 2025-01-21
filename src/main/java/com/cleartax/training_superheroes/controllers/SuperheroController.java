package com.cleartax.training_superheroes.controllers;


import com.cleartax.training_superheroes.dto.Superhero;
import com.cleartax.training_superheroes.dto.SuperheroRequestBody;
import com.cleartax.training_superheroes.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SuperheroController {

    private SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService){
        this.superheroService = superheroService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "username", defaultValue = "World") String username) {
        return String.format("Hello %s!", username);
    }

    @GetMapping("/superhero")
    public Superhero getSuperhero(@RequestParam(value = "name", defaultValue = "Batman") String name,
                                  @RequestParam(value = "universe", defaultValue = "DC") String universe){
        return superheroService.getSuperhero(name, universe);
    }

    @PostMapping("/superhero")
    public Superhero persistSuperhero(@RequestBody SuperheroRequestBody superhero){
        return superheroService.persistSuperhero(superhero);
    }
}
@PutMapping("/superhero/{name}")
public SuperHero updateSuperHero(@PathVariable (value="name") String name,
                                 @RequestBody SuperheroRequestbody superherorequestbody
){
    return superheroservice.UpdateSuperhero(name,superherorequestbody);
}
@DeleteMapping("/superhero/{name}")
public Object deleteSuperhero(@PathVariable String name) {
    return superheroService.removeSuperhero(name);
}