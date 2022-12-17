package salamancacartelos.proposalsservice.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "proposals")
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Min(value = 1)
<<<<<<< HEAD
    private Integer userId;

    @NotBlank
    @Min(value = 1)
    private Integer projectId;
=======
    private Long userId;

    @NotBlank
    @Min(value = 1)
    private Long projectId;
>>>>>>> develop

    @NotBlank
    @Size(max = 256)
    private String title;

    @NotBlank
    private String content;

    public Proposal() {}

<<<<<<< HEAD
    public Proposal(Integer userId, Integer projectId, String title, String content) {
=======
    public Proposal(Long userId, Long projectId, String title, String content) {
>>>>>>> develop
        this.userId = userId;
        this.projectId = projectId;
        this.title = title;
        this.content = content;
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
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
=======
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
>>>>>>> develop
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
