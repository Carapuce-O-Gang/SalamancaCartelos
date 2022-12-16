package salamancacartelos.proposalsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salamancacartelos.proposalsservice.models.Discuss;
import salamancacartelos.proposalsservice.models.Vote;
import salamancacartelos.proposalsservice.repositories.VoteRepository;

import java.util.List;

@Service
public class VoteService {
    @Autowired
    VoteRepository voteRepository;

    public List<Vote> getVotes() {
        return voteRepository.findAll();
    }
}
