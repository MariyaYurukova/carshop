package carshop.domain.entity;




import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "users")
public class User extends BaseEntity {


    private String username;
    private String email;
    private String password;
    private List<Car> cars;

    @Column(nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(
            targetEntity = Car.class,
            mappedBy = "user",
            fetch = FetchType.EAGER
    )
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

