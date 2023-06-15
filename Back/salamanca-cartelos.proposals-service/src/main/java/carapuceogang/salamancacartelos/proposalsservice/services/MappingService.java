package carapuceogang.salamancacartelos.proposalsservice.services;

import carapuceogang.salamancacartelos.proposalsservice.dtos.ProposalDto;
import carapuceogang.salamancacartelos.proposalsservice.models.Proposal;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class MappingService {
    public static void addMappings(ModelMapper modelMapper) {
        ProposalDtoToProposal(modelMapper);
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
               map(source.getName(), destination.getName());
               map(source.getTeams(), destination.getTeams());
           }
        });
    }
    // endregion
}
