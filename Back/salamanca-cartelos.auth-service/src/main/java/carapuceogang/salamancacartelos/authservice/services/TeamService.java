package carapuceogang.salamancacartelos.authservice.services;

import carapuceogang.salamancacartelos.authservice.dtos.TeamDto;
import carapuceogang.salamancacartelos.authservice.models.Team;
import carapuceogang.salamancacartelos.authservice.models.User;
import carapuceogang.salamancacartelos.authservice.repositories.TeamRepository;
import carapuceogang.salamancacartelos.authservice.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    public List<TeamDto> getTeams() {
        return toList(teamRepository.findAll());
    }

    public TeamDto getTeam(Long id) throws Exception {
        Optional<Team> team = teamRepository.findById(id);

        if(team.isEmpty()) {
            throw new Exception("team doesn't exist");
        }

        return toDto(team.get());
    }

    public TeamDto createTeam(TeamDto team) throws Exception {
        if(team.getName() != null && teamRepository.existsByName(team.getName())) {
            throw new Exception("team already taken");
        }

        Team savedTeam = teamRepository.save(toModel(team));

        return toDto(savedTeam);
    }

    public TeamDto updateTeam(Long id, TeamDto team) throws Exception {
        if (!Objects.equals(id, team.getId())) {
            throw new Exception("id doesn't match");
        }

        if (!teamRepository.existsById(id)) {
            throw new Exception("team doesn't exist");
        }

        Optional<Team> t = teamRepository.findById(id);
        if(t.isEmpty()) {
            throw new Exception("team doesn't exist");
        }

        Team updatedTeam = teamRepository.save(toModel(team));

        return toDto(updatedTeam);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    public TeamDto addMemberToTeam(Long id, Long idMember) throws Exception {
        Optional<Team> t = teamRepository.findById(id);
        if(t.isEmpty()) {
            throw new Exception("team id doesn't exist");
        }

        Optional<User> u = userRepository.findById(idMember);
        if(u.isEmpty()) {
            throw new Exception("user id doesn't exist");
        }

        Team team = t.get();
        User user = u.get();

        team.addUser(user);
        Team updatedTeam = teamRepository.save(team);

        return toDto(updatedTeam);
    }

    public void removeMemberFromTeam(Long id, Long idMember) throws Exception {
        Optional<Team> t = teamRepository.findById(id);
        if(t.isEmpty()) {
            throw new Exception("team id doesn't exist");
        }

        Optional<User> u = userRepository.findById(idMember);
        if(u.isEmpty()) {
            throw new Exception("user id doesn't exist");
        }

        Team team = t.get();
        User user = u.get();

        team.removeUser(user);
        teamRepository.save(team);
    }

    // Mapping
    public List<TeamDto> toList(List<Team> teams) {
        return MappingService.map(teams, TeamDto.class, modelMapper);
    }

    public TeamDto toDto(Team team) {
        return MappingService.map(team, TeamDto.class, modelMapper);
    }

    public Team toModel(TeamDto team) {
        return MappingService.map(team, Team.class, modelMapper);
    }
}
