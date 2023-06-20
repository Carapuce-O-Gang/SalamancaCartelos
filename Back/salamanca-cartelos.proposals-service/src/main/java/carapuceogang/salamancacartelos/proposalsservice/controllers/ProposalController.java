package carapuceogang.salamancacartelos.proposalsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carapuceogang.salamancacartelos.proposalsservice.dtos.ProposalDto;
import carapuceogang.salamancacartelos.proposalsservice.services.ProposalService;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/proposal")
public class ProposalController {
    @Autowired
    ProposalService proposalService;

    @GetMapping
    public ResponseEntity<List<ProposalDto>> getProposals() {
        List<ProposalDto> proposals = proposalService.getProposals();
        return ResponseEntity.ok(proposals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProposalDto> getProposal(@PathVariable Long id) throws Exception {
        ProposalDto proposal = proposalService.getProposal(id);
        return ResponseEntity.ok(proposal);
    }

    @PostMapping
    public ResponseEntity<ProposalDto> createProposal(@Valid @RequestBody ProposalDto proposal) throws Exception {
        ProposalDto savedProposal = proposalService.createProposal(proposal);
        return ResponseEntity.ok(savedProposal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProposalDto> updateProject(@PathVariable Long id, @Valid @RequestBody ProposalDto proposal) throws Exception {
        ProposalDto updatedProposal = proposalService.updateProposal(id, proposal);
        return ResponseEntity.ok(updatedProposal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) throws Exception{
        proposalService.deleteProposal(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
