package carshop.web.servlets;



import carshop.domain.models.binding.CarCreateBindingModel;


import carshop.domain.models.service.CarCreateServiceModel;
import carshop.domain.models.service.CarServiceModel;
import carshop.domain.models.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import carshop.service.CarService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cars/create")
public class CarsCreateServlet extends HttpServlet {

    private final CarService carService;
    private final ModelMapper modelMapper;
    private final UserServiceModel userServiceModel;

    @Inject
    public CarsCreateServlet(CarService carService, ModelMapper modelMapper, UserServiceModel userServiceModel) {
        this.carService = carService;
        this.modelMapper = modelMapper;
        this.userServiceModel = userServiceModel;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/car-create.jsp")
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        CarCreateBindingModel carCreateBindingModel = (CarCreateBindingModel) req
                .getAttribute("model");

        CarServiceModel carServiceModel = this.modelMapper.map(carCreateBindingModel, CarServiceModel.class);


       UserServiceModel userServiceModel = new UserServiceModel();
        userServiceModel.setUsername(carCreateBindingModel.getUser());

              carServiceModel.setUserUsername(userServiceModel);

              this.carService.uploadCar(carServiceModel);

        resp.sendRedirect("/home");


    }
}












