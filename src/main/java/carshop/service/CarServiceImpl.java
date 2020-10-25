package carshop.service;

import carshop.domain.entity.Car;
import carshop.domain.entity.User;
import carshop.domain.models.service.CarCreateServiceModel;
import carshop.domain.models.service.CarServiceModel;
import carshop.repository.CarRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    private final EntityManager entityManager;
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final UserService userService;

    @Inject
    public CarServiceImpl(EntityManager entityManager, ModelMapper modelMapper, CarRepository carRepository, UserService userService) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.userService = userService;
    }


    @Override
    public List<CarServiceModel> getAll() {
        return entityManager.createQuery("select c from Car c", Car.class)
                .getResultList()
                .stream()
                .map(car -> modelMapper.map(car, CarServiceModel.class))
                .collect(Collectors.toList());
    }


    @Override
    public boolean uploadCar(CarServiceModel carServiceModel) {
      carServiceModel
     .setUserUsername(this.userService.findUserByUsername(carServiceModel.getUserUsername().getUsername()));

        try {
          this.carRepository.save(this.modelMapper.map(carServiceModel, Car.class));


       } catch (Exception e) {
           return false;
    }
       return true;

   }
}