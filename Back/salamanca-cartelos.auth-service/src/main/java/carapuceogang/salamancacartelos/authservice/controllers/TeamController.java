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
    public ResponseEntity<List<TeamDto>> getTeams() {
        List<TeamDto> teams = teamService.getTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeam(@PathVariable Long id) throws Exception {
        TeamDto team = teamService.getTeam(id);
        return ResponseEntity.ok(team);
    }

    @PostMapping("/")
    public ResponseEntity<?> createTeam(@Valid @RequestBody TeamDto team) throws Exception {
        TeamDto savedTeam = teamService.createTeam(team);
        return ResponseEntity.ok(savedTeam);
    }

    @PostMapping("/{id}/member/{idMember}")
    public ResponseEntity<?> addMemberToTeam(@PathVariable Long id, @PathVariable Long idMember) throws Exception {
        TeamDto savedTeam = teamService.addMemberToTeam(id, idMember);
        return ResponseEntity.ok(savedTeam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Long id, @Valid @RequestBody TeamDto team) throws Exception {
        TeamDto updatedTeam = teamService.updateTeam(id, team);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) throws Exception{
        teamService.deleteTeam(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/member/{idMember}")
    public ResponseEntity<?> deleteMemberFromTeam(@PathVariable Long id, @PathVariable Long idMember) throws Exception{
        teamService.removeMemberFromTeam(id, idMember);
        return new ResponseEntity(HttpStatus.OK);
    }
}
