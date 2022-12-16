package salamancacartelos.proposalsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salamancacartelos.proposalsservice.services.VoteService;

@RestController
@RequestMapping("/api/vote")
public class VoteController {
    @Autowired
    VoteService voteService;
}
