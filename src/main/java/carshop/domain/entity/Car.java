package carshop.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car  extends BaseEntity{
    private String brand;
    private String model;
    private String year;
    private String engine;
    private User user;


    @Column(name = "brand", nullable = false)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "year", nullable = false)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }



    @Column(name = "engine", nullable = false)
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }



    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "user",
            referencedColumnName = "id",
            nullable = false
    )
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
