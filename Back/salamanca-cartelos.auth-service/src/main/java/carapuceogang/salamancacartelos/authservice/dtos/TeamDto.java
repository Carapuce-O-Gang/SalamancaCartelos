package carapuceogang.salamancacartelos.authservice.dtos;

import carapuceogang.salamancacartelos.authservice.models.Project;
import carapuceogang.salamancacartelos.authservice.models.User;

import java.util.Set;

public class TeamDto {
    private String name;
    private Set<User> users;
    private Project project;

    public TeamDto(String name) {
        this.name = name;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
