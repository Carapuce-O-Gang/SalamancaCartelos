package carapuceogang.salamancacartelos.proposalsservice.services;

import carapuceogang.salamancacartelos.proposalsservice.dtos.ProposalDto;
import carapuceogang.salamancacartelos.proposalsservice.dtos.DiscussionDto;
import carapuceogang.salamancacartelos.proposalsservice.dtos.MessageDto;
import carapuceogang.salamancacartelos.proposalsservice.models.Proposal;
import carapuceogang.salamancacartelos.proposalsservice.models.Discussion;
import carapuceogang.salamancacartelos.proposalsservice.models.Message;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class MappingService {
    public static void addMappings(ModelMapper modelMapper) {
        ProposalDtoToProposal(modelMapper);
        ProposalToProposalDto(modelMapper);
        DiscussionDtoToDiscussion(modelMapper);
        DiscussionToDiscussionDto(modelMapper);
        MessageDtoToMessage(modelMapper);
        MessageToMessageDto(modelMapper);
    }

    public static <O, I> List<O> map(final List<I> list, Class<O> outputClass, ModelMapper mapper) {
        return list.stream()
                .map(t -> map(t, outputClass, mapper))
                .collect(Collectors.toList());
    }

    public static <O, I> O map(final I input, Class<O> outputClass, ModelMapper mapper) {
        return mapper.map(input, outputClass);
    }

    // Mapping Methods

    // region Proposal
    private static void ProposalDtoToProposal(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<ProposalDto, Proposal>() {
           @Override
           protected void configure() {
                map(source.getId(), destination.getId());
                map(source.getTitle(), destination.getTitle());
                map(source.getContent(), destination.getContent());
                map(source.getProjectId(), destination.getProjectId());
                map(source.getUserId(), destination.getUserId());
           }
        });
    }

    private static void ProposalToProposalDto(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<Proposal, ProposalDto>() {
           @Override
           protected void configure() {
                map(source.getId(), destination.getId());
                map(source.getTitle(), destination.getTitle());
                map(source.getContent(), destination.getContent());
                map(source.getProjectId(), destination.getProjectId());
                map(source.getUserId(), destination.getUserId());
           }
        });
    }
    // endregion

    // region Discussion
    private static void DiscussionDtoToDiscussion(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<DiscussionDto, Discussion>() {
           @Override
           protected void configure() {
                map(source.getId(), destination.getId());
                map(source.getMessages(), destination.getMessages());
                map(source.getProposal(), destination.getProposal());
           }
        });
    }

    private static void DiscussionToDiscussionDto(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<Discussion, DiscussionDto>() {
           @Override
           protected void configure() {
                map(source.getId(), destination.getId());
                map(source.getMessages(), destination.getMessages());
                map(source.getProposal(), destination.getProposal());
           }
        });
    }
    // endregion

    // region Message
    private static void MessageDtoToMessage(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<MessageDto, Message>() {
           @Override
           protected void configure() {
                map(source.getId(), destination.getId());
                map(source.getContent(), destination.getContent());
                map(source.getUserId(), destination.getUserId());
                map(source.getDiscussion(), destination.getDiscussion());
           }
        });
    }

    private static void MessageToMessageDto(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<Message, MessageDto>() {
           @Override
           protected void configure() {
                map(source.getId(), destination.getId());
                map(source.getContent(), destination.getContent());
                map(source.getUserId(), destination.getUserId());
                map(source.getDiscussion(), destination.getDiscussion());
           }
        });
    }
    // endregion
}
