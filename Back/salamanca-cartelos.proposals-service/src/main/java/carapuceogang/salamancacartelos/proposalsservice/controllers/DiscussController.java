package carapuceogang.salamancacartelos.proposalsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carapuceogang.salamancacartelos.proposalsservice.dtos.DiscussionDto;
import carapuceogang.salamancacartelos.proposalsservice.services.DiscussionService;

import java.util.List;

@RestController
@RequestMapping("/api/discussion")
public class DiscussController {
    @Autowired
    DiscussionService discussionService;

    @GetMapping
    public ResponseEntity<List<DiscussionDto>> getDiscussions() {
        List<DiscussionDto> discussions = discussionService.getDiscussions();
        return ResponseEntity.ok(discussions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscussionDto> getDiscussion(@PathVariable Long id) throws Exception {
        DiscussionDto discussion = discussionService.getDiscussion(id);
        return ResponseEntity.ok(discussion);
    }
}
