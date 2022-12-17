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
    private Long userId;

    @NotBlank
    private Boolean isVoted;

    public Vote() {}

    public Vote(Long userId, Boolean isVoted) {
        this.userId = userId;
        this.isVoted = isVoted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getVoted() {
        return isVoted;
    }

    public void setVoted(Boolean voted) {
        isVoted = voted;
    }
}
