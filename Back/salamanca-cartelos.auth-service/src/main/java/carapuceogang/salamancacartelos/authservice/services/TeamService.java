package carapuceogang.salamancacartelos.authservice.services;

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

        if(!team.isPresent()) {
            throw new Exception("team doesn't exist");
        }

        return team.get();
    }

    public Team createTeam(Team team) throws Exception {
        if(
            team.getName() != null && teamRepository.existsByName(team.getName())
            || team.getId() != null && teamRepository.existsById(team.getId())
        ) {
            throw new Exception("team already taken");
        }

        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team team) throws Exception {
        if (id != team.getId()) {
            throw new IllegalArgumentException("team id doesn't match");
        }

        if (!teamRepository.existsById(id)) {
            throw new Exception("team doesn't exist");
        }

        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
