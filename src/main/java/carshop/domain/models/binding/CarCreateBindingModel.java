package carshop.domain.models.binding;

public class CarCreateBindingModel {

    private String brand;
    private String model;
    private String year;
    private String engine;
   private String user;

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

  public String getUser() {
     return user;
    }

    public void setUser(String userUser) {
       this.user= userUser;
    }
}
