package cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.repos;

import cat.itacademy.barcelonactiva.Ros.Ivan.s04.t02.n03.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepos extends MongoRepository<Fruit,Integer> {

}
