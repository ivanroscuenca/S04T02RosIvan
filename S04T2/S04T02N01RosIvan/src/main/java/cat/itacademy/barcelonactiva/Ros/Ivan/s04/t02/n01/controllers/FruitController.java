package cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n01.domain.Fruit;
import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n01.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//is a RestController which has request mapping methods for RESTful requests.Service is required.
@RestController
public class FruitController {
@Autowired
 private FruitService fruitService;

//Without
//    @PostMapping("/fruit/add")
//    public Fruit addFruit(@RequestBody Fruit fruit) {
//    return fruitService.createFruit(fruit);
//    }
//
//    @PutMapping("/fruit/update")
//    public Fruit updateFruit(@RequestBody Fruit fruit) {
//        return fruitService.updateFruit(fruit);
//    }
//
//    @GetMapping("/fruit/getOne/{id}")
//    public Fruit getFruitById(@PathVariable Integer id) {
//        return fruitService.getFruitById(id);
//    }
//
//    @GetMapping("/fruit/getAll")
//    public List<Fruit> getAllFruits() {
//        return fruitService.getFruits();
//    }
//
//    @DeleteMapping("/fruit/delete/{id}")
//    public String deleteUser(@PathVariable Integer id) {
//        return fruitService.deleteFruitById(id);
//    }

//    Try-catch possibility
//    @PostMapping("/fruit/add")
//    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
//
//        try {
//            Fruit createdFruit = fruitService.createFruit(fruit);
//            return new ResponseEntity<>(createdFruit, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return (ResponseEntity<>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    };

    @PostMapping("/fruit/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
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



