package carshop.repository;

import carshop.domain.entity.Car;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class CarRepositoryImpl implements CarRepository {

    private final EntityManager entityManager;
    private final ModelMapper modelMapper;




    @Inject
    public CarRepositoryImpl(EntityManager entityManager, ModelMapper modelMapper) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
    }





    @Override
    public Car save(Car entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public Car update(Car car) {
        this.entityManager.merge(car);
        return car;
    }

}