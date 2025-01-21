package com.cleartax.training_superheroes.services;

import com.cleartax.training_superheroes.dto.Superhero;
import com.cleartax.training_superheroes.dto.SuperheroRequestBody;
import com.cleartax.training_superheroes.repos.SuperheroRepository;
import org.springframework.stereotype.Service;

@Service
public class SuperheroService {

    private SuperheroRepository superheroRepository;

    public SuperheroService(SuperheroRepository superheroRepository){
        this.superheroRepository = superheroRepository;
    }

    public Superhero getSuperhero(String name, String universe){
        if(null != name){
            return getByName(name);
//        } else if (null != universe){
//            return getByUniverse(universe);
        } else{
            throw new RuntimeException("Not found");
        }
    }

    private Superhero getByName(String name){
        return getDummyDate(name);
    }

//    private Superhero  getByUniverse(String universe){
//        Superhero superhero =  new Superhero();
//        superhero.setUniverse(universe);
//        return superhero;
//    }

    private Superhero getDummyDate(String name){
        Superhero superhero =  new Superhero();
        superhero.setName(name);
        return superhero;
    }

    public Superhero persistSuperhero(SuperheroRequestBody requestBody){
        Superhero superhero = new Superhero();
        superhero.setName(requestBody.getName());
        superhero.setPower(requestBody.getPower());
        superhero.setUniverse(requestBody.getUniverse());

        return superheroRepository.save(superhero);
    }
}
public SuperHero UpdateSuperhero(String name ,SuperheroRequestbody requestBody){
    var result=superheroRepository.findAllByName(name);
    if(result.size()==0){
        throw new RuntimeException("no such superhero");
    }
    else{
        result.get(0).setName(requestBody.getName());
        result.get(0).setUniverse(requestBody.getUniverse());
        result.get(0).setPower(requestBody.getPower());
        superheroRepository.save(result.get(0));
        return result.get(0);
    }
}
public Object removeSuperhero(String name) {
    var ans = superheroRepository.removeByName(name);
    if (ans.size() == 0) {
        throw new RuntimeException("No superheroes with the name: " + name);
    }
    else {
        return "Superhero with name: " + name + " removed";
    }
}