package salamancacartelos.proposalsservice.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "votes")
public class Vote {
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
    private Boolean isVoted;

    public Vote() {}

<<<<<<< HEAD
    public Vote(Integer userId, Boolean isVoted) {
=======
    public Vote(Long userId, Boolean isVoted) {
>>>>>>> develop
        this.userId = userId;
        this.isVoted = isVoted;
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

    public Boolean getVoted() {
        return isVoted;
    }

    public void setVoted(Boolean voted) {
        isVoted = voted;
    }
}
