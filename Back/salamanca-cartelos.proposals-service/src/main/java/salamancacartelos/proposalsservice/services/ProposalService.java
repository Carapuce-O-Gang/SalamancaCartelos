package salamancacartelos.proposalsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======
import salamancacartelos.proposalsservice.dtos.ProposalDto;
>>>>>>> develop
import salamancacartelos.proposalsservice.models.Proposal;
import salamancacartelos.proposalsservice.repositories.ProposalRepository;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> develop

@Service
public class ProposalService {
    @Autowired
    ProposalRepository proposalRepository;

    public List<Proposal> getProposals() {
        return proposalRepository.findAll();
    }
<<<<<<< HEAD
=======

    public Proposal getProposal(Long id) throws Exception {
        Optional<Proposal> proposal = proposalRepository.findById(id);

        if(proposal.isEmpty()) {
            throw new Exception("proposal not found");
        }

        return proposal.get();
    }

    public Proposal createProposal(ProposalDto proposalDto) throws Exception {
        if (proposalDto.getTitle() != null && proposalRepository.existsByTitle(proposalDto.getTitle())) {
            throw new Exception("proposal title already exist");
        }

        Proposal proposal = new Proposal();
        proposal.setTitle(proposalDto.getTitle());
        proposal.setContent(proposalDto.getContent());

        return proposalRepository.save(proposal);
    }

    public Proposal updateProposal(Long id, ProposalDto proposalDto) throws Exception {
        if (!proposalRepository.existsById(id)) {
            throw new Exception("proposal doesn't exist");
        }

        Optional<Proposal> p = proposalRepository.findById(id);

        if (p.isEmpty()) {
            throw new Exception("proposal doesn't exist");
        }

        Proposal proposal = p.get();
        proposal.setTitle(proposalDto.getTitle());
        proposal.setContent(proposalDto.getContent());

        return proposalRepository.save(proposal);
    }

    public void deleteProposal(Long id) {
        proposalRepository.deleteById(id);
    }
>>>>>>> develop
}
