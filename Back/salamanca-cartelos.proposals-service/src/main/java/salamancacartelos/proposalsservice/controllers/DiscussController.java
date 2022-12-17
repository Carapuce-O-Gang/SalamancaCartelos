package salamancacartelos.proposalsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salamancacartelos.proposalsservice.services.DiscussService;

=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salamancacartelos.proposalsservice.models.Discuss;
import salamancacartelos.proposalsservice.services.DiscussService;

import java.util.List;

>>>>>>> develop
@RestController
@RequestMapping("/api/discuss")
public class DiscussController {
    @Autowired
    DiscussService discussService;
<<<<<<< HEAD
=======

    @GetMapping("/")
    public ResponseEntity<List<Discuss>> getDiscussions() {
        List<Discuss> discussions = discussService.getDiscussions();
        return ResponseEntity.ok(discussions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discuss> getDiscuss(@PathVariable Long id) throws Exception {
        Discuss discuss = discussService.getDiscuss(id);
        return ResponseEntity.ok(discuss);
    }
>>>>>>> develop
}
