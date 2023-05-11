package cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n01.services;

import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n01.domain.Fruit;
import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n01.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//Service implements methods from FruitRepository. These methods will be used in Controller.
@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit createFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }
    public List<Fruit> getFruits() {
        return fruitRepository.findAll();
    }

    public Fruit getFruitById(int id) {
        return fruitRepository.findById(id).orElse(null);
    }

    public Fruit updateFruit(Fruit fruit) {
        Fruit oldFruit;
        Optional<Fruit> optionalFruit=fruitRepository.findById(fruit.getId());
        if(optionalFruit.isPresent()) {
            oldFruit=optionalFruit.get();
            oldFruit.setName(fruit.getName());
            oldFruit.setQuantity(fruit.getQuantity());
            fruitRepository.save(oldFruit);
        }else {
            return new Fruit();
        }
        return oldFruit;
    }


    public String deleteFruitById(int id) {
        fruitRepository.deleteById(id);
        return "User got deleted";
    }

}
