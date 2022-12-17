package salamancacartelos.proposalsservice.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "discussions")
public class Discuss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Min(value = 1)
<<<<<<< HEAD
    private Integer userId;
=======
    private Long userId;
>>>>>>> develop

    @NotBlank
    private String message;

    public Discuss() {}

<<<<<<< HEAD
    public Discuss(Integer userId, String message) {
=======
    public Discuss(Long userId, String message) {
>>>>>>> develop
        this.userId = userId;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
=======
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
>>>>>>> develop
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
