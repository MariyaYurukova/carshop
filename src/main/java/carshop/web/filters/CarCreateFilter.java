package carshop.web.filters;

import carshop.domain.models.binding.CarCreateBindingModel;
import carshop.domain.models.service.CarCreateServiceModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/cars/create")
public class CarCreateFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (req.getMethod().toLowerCase().equals("post")) {
          CarCreateBindingModel carCreateBindingModel = new CarCreateBindingModel();
          carCreateBindingModel.setBrand(req.getParameter("brand"));
          carCreateBindingModel.setModel(req.getParameter("model"));
         carCreateBindingModel.setYear(req.getParameter("year"));
        carCreateBindingModel.setEngine(req.getParameter("engine"));

 // carCreateBindingModel.setUser(req.getParameter("userId"));
    carCreateBindingModel.setUser((String)(req.getSession().getAttribute("username")));

            req.setAttribute("model", carCreateBindingModel);
        }

        chain.doFilter(req, resp);
    }
}



