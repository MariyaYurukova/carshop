package carshop.repository;

import carshop.domain.entity.Car;

public interface CarRepository extends GenericRepository<Car, String> {

  Car update(Car entity);

}
