package carshop.service;

import carshop.domain.models.binding.CarCreateBindingModel;
import carshop.domain.models.service.CarCreateServiceModel;
import carshop.domain.models.service.CarServiceModel;


import java.util.List;

public interface CarService {

 //   void saveCar(CarServiceModel carServiceModel);

    List<CarServiceModel> getAll();

 //  String create(CarCreateServiceModel serviceModel);
 // String create(CarCreateServiceModel car);

   boolean uploadCar(CarServiceModel carServiceModel);

}