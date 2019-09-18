package hello.repos;

import org.springframework.data.repository.CrudRepository;

import hello.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
