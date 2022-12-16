package salamancacartelos.proposalsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salamancacartelos.proposalsservice.models.Proposal;
import salamancacartelos.proposalsservice.repositories.ProposalRepository;

import java.util.List;

@Service
public class ProposalService {
    @Autowired
    ProposalRepository proposalRepository;

    public List<Proposal> getProposals() {
        return proposalRepository.findAll();
    }
}
