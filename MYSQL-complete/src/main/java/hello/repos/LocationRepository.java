package hello.repos;

import org.springframework.data.repository.CrudRepository;

import hello.entities.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {

}
