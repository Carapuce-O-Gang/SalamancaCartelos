package salamancacartelos.proposalsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salamancacartelos.proposalsservice.services.DiscussService;

@RestController
@RequestMapping("/api/discuss")
public class DiscussController {
    @Autowired
    DiscussService discussService;
}
