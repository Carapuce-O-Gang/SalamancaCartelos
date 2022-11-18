package carapuceogang.salamancacartelos.authservice.controllers;

import carapuceogang.salamancacartelos.authservice.dtos.TeamDto;
import carapuceogang.salamancacartelos.authservice.models.Team;
import carapuceogang.salamancacartelos.authservice.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/")
    public ResponseEntity<List<Team>> getTeams() {
        List<Team> teams = teamService.getTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeam(@PathVariable Long id) throws Exception {
        Team team = teamService.getTeam(id);
        return ResponseEntity.ok(team);
    }

    @PostMapping("/")
    public ResponseEntity<?> createTeam(@Valid @RequestBody TeamDto teamDto) throws Exception {
        Team savedTeam = teamService.createTeam(teamDto);
        return ResponseEntity.ok(savedTeam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Long id, @Valid @RequestBody TeamDto teamDto) throws Exception {
        Team updatedTeam = teamService.updateTeam(id, teamDto);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) throws Exception{
        teamService.deleteTeam(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
