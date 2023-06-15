package carapuceogang.salamancacartelos.proposalsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carapuceogang.salamancacartelos.proposalsservice.models.Discuss;
import carapuceogang.salamancacartelos.proposalsservice.services.DiscussService;

import java.util.List;

@RestController
@RequestMapping("/api/discuss")
public class DiscussController {
    @Autowired
    DiscussService discussService;

    @GetMapping("")
    public ResponseEntity<List<Discuss>> getDiscussions() {
        List<Discuss> discussions = discussService.getDiscussions();
        return ResponseEntity.ok(discussions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discuss> getDiscuss(@PathVariable Long id) throws Exception {
        Discuss discuss = discussService.getDiscuss(id);
        return ResponseEntity.ok(discuss);
    }
}
