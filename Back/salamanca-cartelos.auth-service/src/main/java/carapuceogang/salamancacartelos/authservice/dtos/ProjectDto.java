package carapuceogang.salamancacartelos.authservice.dtos;

import carapuceogang.salamancacartelos.authservice.models.Team;
import java.util.Set;

public class ProjectDto {
    private String name;
    private Set<Team> teams;

    public ProjectDto(String name, Set<Team> teams) {
        this.name = name;
        this.teams = teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
