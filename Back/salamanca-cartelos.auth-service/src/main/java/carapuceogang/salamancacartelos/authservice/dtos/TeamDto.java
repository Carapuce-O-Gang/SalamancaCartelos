package carapuceogang.salamancacartelos.authservice.dtos;

import carapuceogang.salamancacartelos.authservice.models.User;

import java.util.Set;

public class TeamDto {
    private Long id;
    private String name;
    private Set<User> users;
    private ProjectDto project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }
}
