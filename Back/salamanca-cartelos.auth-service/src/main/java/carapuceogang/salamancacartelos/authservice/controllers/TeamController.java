package carapuceogang.salamancacartelos.authservice.controllers;

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
    public ResponseEntity<?> createTeam(@Valid @RequestBody Team team) throws Exception {
        Team savedTeam = teamService.createTeam(team);
        return ResponseEntity.ok(savedTeam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @Valid @RequestBody Team team) throws Exception {
        Team updatedTeam = teamService.updateTeam(id, team);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) throws Exception{
        boolean isDeleted = teamService.deleteTeam(id);

        if (!isDeleted) {
            throw new Exception("something went wrong");
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
