package carapuceogang.salamancacartelos.authservice.services;

import carapuceogang.salamancacartelos.authservice.dtos.TeamDto;
import carapuceogang.salamancacartelos.authservice.models.Team;
import carapuceogang.salamancacartelos.authservice.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team getTeam(Long id) throws Exception {
        Optional<Team> team = teamRepository.findById(id);

        if(team.isEmpty()) {
            throw new Exception("team doesn't exist");
        }

        return team.get();
    }

    public Team createTeam(TeamDto teamDto) throws Exception {
        if(teamDto.getName() != null && teamRepository.existsByName(teamDto.getName())) {
            throw new Exception("team already taken");
        }

        Team team = new Team();
        team.setName(teamDto.getName());
        team.setUsers(teamDto.getUsers());
        team.setProject(teamDto.getProject());

        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, TeamDto teamDto) throws Exception {
        if (!teamRepository.existsById(id)) {
            throw new Exception("team doesn't exist");
        }

        Optional<Team> t = teamRepository.findById(id);

        if(t.isEmpty()) {
            throw new Exception("team doesn't exist");
        }

        Team team = t.get();
        team.setName(teamDto.getName());
        team.setUsers(teamDto.getUsers());
        team.setProject(teamDto.getProject());

        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
