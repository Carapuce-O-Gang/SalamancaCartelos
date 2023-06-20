package carapuceogang.salamancacartelos.proposalsservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carapuceogang.salamancacartelos.proposalsservice.dtos.DiscussionDto;
import carapuceogang.salamancacartelos.proposalsservice.dtos.ProposalDto;
import carapuceogang.salamancacartelos.proposalsservice.models.Discussion;
import carapuceogang.salamancacartelos.proposalsservice.models.Proposal;
import carapuceogang.salamancacartelos.proposalsservice.repositories.DiscussionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionService {
    @Autowired
    DiscussionRepository discussionRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<DiscussionDto> getDiscussions() {
        return toList(discussionRepository.findAll());
    }

    public DiscussionDto getDiscussion(Long id) throws Exception {
        Optional<Discussion> discussion = discussionRepository.findById(id);

        if(discussion.isEmpty()) {
            throw new Exception("discuss doesn't exist");
        }

        return toDto(discussion.get());
    }

    public DiscussionDto createDiscussion(DiscussionDto discussion) throws Exception {
        Discussion savedDiscussion = discussionRepository.save(toModel(discussion));
        
        return toDto(savedDiscussion);
    }

    // Mapping
    public List<DiscussionDto> toList(List<Discussion> teams) {
        return MappingService.map(teams, DiscussionDto.class, modelMapper);
    }

    public DiscussionDto toDto(Discussion discussion) {
        return MappingService.map(discussion, DiscussionDto.class, modelMapper);
    }

    public Discussion toModel(DiscussionDto discussion) {
        return MappingService.map(discussion, Discussion.class, modelMapper);
    }
}
