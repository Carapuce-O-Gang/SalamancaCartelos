package carapuceogang.salamancacartelos.proposalsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carapuceogang.salamancacartelos.proposalsservice.dtos.ProposalDto;
import carapuceogang.salamancacartelos.proposalsservice.models.Proposal;
import carapuceogang.salamancacartelos.proposalsservice.repositories.ProposalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProposalService {
    @Autowired
    ProposalRepository proposalRepository;

    public List<Proposal> getProposals() {
        return proposalRepository.findAll();
    }

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
}
