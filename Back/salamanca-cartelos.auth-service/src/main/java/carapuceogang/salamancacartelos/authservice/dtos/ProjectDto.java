package carapuceogang.salamancacartelos.authservice.dtos;

import java.util.Set;

public class ProjectDto {
    private Long id;
    private String name;
    private Set<TeamDto> teams;

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

    public Set<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamDto> teams) {
        this.teams = teams;
    }
}
