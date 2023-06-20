package carapuceogang.salamancacartelos.proposalsservice.services;

import org.modelmapper.ModelMapper;
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

    @Autowired
    ModelMapper modelMapper;

    public List<ProposalDto> getProposals() {
        return toList(proposalRepository.findAll());
    }

    public ProposalDto getProposal(Long id) throws Exception {
        Optional<Proposal> proposal = proposalRepository.findById(id);

        if(proposal.isEmpty()) {
            throw new Exception("proposal doesn't exist");
        }

        return toDto(proposal.get());
    }

    public ProposalDto createProposal(ProposalDto proposal) throws Exception {
        if (proposal.getTitle() != null && proposalRepository.existsByTitle(proposal.getTitle())) {
            throw new Exception("proposal already exist");
        }

        Proposal savedProposal = proposalRepository.save(toModel(proposal));

        return toDto(savedProposal);
    }

    public ProposalDto updateProposal(Long id, ProposalDto proposal) throws Exception {
        if (!proposalRepository.existsById(id)) {
            throw new Exception("proposal doesn't exist");
        }

        Optional<Proposal> p = proposalRepository.findById(id);
        if (p.isEmpty()) {
            throw new Exception("proposal doesn't exist");
        }

        Proposal savedProposal = proposalRepository.save(toModel(proposal));

        return toDto(savedProposal);
    }

    public void deleteProposal(Long id) {
        proposalRepository.deleteById(id);
    }

    // Mapping
    public List<ProposalDto> toList(List<Proposal> proposals) {
        return MappingService.map(proposals, ProposalDto.class, modelMapper);
    }

    public ProposalDto toDto(Proposal proposal) {
        return MappingService.map(proposal, ProposalDto.class, modelMapper);
    }

    public Proposal toModel(ProposalDto proposal) {
        return MappingService.map(proposal, Proposal.class, modelMapper);
    }
}
