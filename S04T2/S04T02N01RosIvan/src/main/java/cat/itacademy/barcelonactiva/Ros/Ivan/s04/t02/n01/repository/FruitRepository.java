package cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n01.repository;

import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n01.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Is an interface that extends JpaRepository
@Repository
public interface FruitRepository extends JpaRepository<Fruit,Integer> {

}
