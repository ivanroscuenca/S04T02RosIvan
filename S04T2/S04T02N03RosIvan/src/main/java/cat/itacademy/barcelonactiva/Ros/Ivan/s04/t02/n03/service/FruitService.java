package cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.service;


import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.domain.Fruit;
import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.repos.FruitRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Service implements methods from FruitRepository. These methods will be used in Controller.
@Service
public class FruitService {

    @Autowired
    private FruitRepos fruitRepos;

    public Fruit createFruit(Fruit fruit) {
        return fruitRepos.save(fruit);
    }
    public List<Fruit> getFruits() {
        return fruitRepos.findAll();
    }

    public Fruit getFruitById(int id) {
        return fruitRepos.findById(id).orElse(null);
    }

    public Fruit updateFruit(Fruit fruit) {
        Fruit oldFruit;
        Optional<Fruit> optionalFruit= fruitRepos.findById(fruit.getId());
        if(optionalFruit.isPresent()) {
            oldFruit=optionalFruit.get();
            oldFruit.setName(fruit.getName());
            oldFruit.setQuantity(fruit.getQuantity());
            fruitRepos.save(oldFruit);
        }else {
            return new Fruit();
        }
        return oldFruit;
    }


    public String deleteFruitById(int id) {
        fruitRepos.deleteById(id);
        return "User got deleted";
    }

}
