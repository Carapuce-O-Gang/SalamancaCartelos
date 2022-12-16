package salamancacartelos.proposalsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salamancacartelos.proposalsservice.models.Discuss;
import salamancacartelos.proposalsservice.models.Proposal;
import salamancacartelos.proposalsservice.repositories.DiscussRepository;

import java.util.List;

@Service
public class DiscussService {
    @Autowired
    DiscussRepository discussRepository;

    public List<Discuss> getDiscussions() {
        return discussRepository.findAll();
    }
}
