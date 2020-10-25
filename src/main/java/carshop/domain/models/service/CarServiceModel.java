package carshop.domain.models.service;

public class CarServiceModel {
    private String id;
    private String brand;
    private String model;
    private String year;
    private String engine;
    private UserServiceModel userUsername;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }


    public UserServiceModel getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(UserServiceModel userUsername) {
        this.userUsername = userUsername;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
