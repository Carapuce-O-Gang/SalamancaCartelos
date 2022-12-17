package salamancacartelos.proposalsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salamancacartelos.proposalsservice.services.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import salamancacartelos.proposalsservice.models.Vote;

import java.util.List;
@RestController
@RequestMapping("/api/vote")
public class VoteController {
    @Autowired
    VoteService voteService;

    @GetMapping("/")
    public ResponseEntity<List<Vote>> getVotes() {
        List<Vote> votes = voteService.getVotes();
        return ResponseEntity.ok(votes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVote(@PathVariable Long id) throws Exception {
        Vote vote = voteService.getVote(id);
        return ResponseEntity.ok(vote);
    }
}
