package cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.controller;


import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.domain.Fruit;
import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.service.FruitService;
import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.domain.Fruit.SEQUENCE_NAME;

//is a RestController which has request mapping methods for RESTful requests.Service is required.
@RestController
public class FruitController {
    @Autowired
    private FruitService fruitService;
    @Autowired
    private SequenceGeneratorService sequenceService;

    @PostMapping("/fruit/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        fruit.setId((int) sequenceService.generateSequence(SEQUENCE_NAME));
        Fruit createdFruit = fruitService.createFruit(fruit);
        if (createdFruit != null) {
            return new ResponseEntity<>(createdFruit, HttpStatus.CREATED);
        } else {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    };

    @PutMapping("/fruit/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.updateFruit(fruit);
        if (updatedFruit != null) {
            return new ResponseEntity<>(updatedFruit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

    @GetMapping("/fruit/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Integer id) {
        Fruit fruit = fruitService.getFruitById(id);
        if (fruit != null) {
            return new ResponseEntity<>(fruit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

    @GetMapping("/fruit/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getFruits();
        if (!fruits.isEmpty()) {
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

    @DeleteMapping("/fruit/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        String message = fruitService.deleteFruitById(id);
        if (message.equals("User got deleted")) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    };


}



