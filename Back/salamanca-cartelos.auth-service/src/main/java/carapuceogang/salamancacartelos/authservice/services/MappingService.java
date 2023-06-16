package carapuceogang.salamancacartelos.authservice.services;

import carapuceogang.salamancacartelos.authservice.dtos.ProjectDto;
import carapuceogang.salamancacartelos.authservice.dtos.TeamDto;
import carapuceogang.salamancacartelos.authservice.dtos.UserDto;
import carapuceogang.salamancacartelos.authservice.models.Project;
import carapuceogang.salamancacartelos.authservice.models.Team;
import carapuceogang.salamancacartelos.authservice.models.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class MappingService {
    public static void addMappings(ModelMapper modelMapper) {
        ProjectDtoToProject(modelMapper);
        ProjectToProjectDto(modelMapper);
        UserToUserDto(modelMapper);
        TeamToTeamDto(modelMapper);
        TeamDtoToTeam(modelMapper);
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

    // region Project
    private static void ProjectDtoToProject(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<ProjectDto, Project>() {
           @Override
           protected void configure() {
               map(source.getId(), destination.getId());
               map(source.getName(), destination.getName());
               map(source.getTeams(), destination.getTeams());
           }
        });
    }

    private static void ProjectToProjectDto(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<Project, ProjectDto>() {
            @Override
            protected void configure() {
                map(source.getId(), destination.getId());
                map(source.getName(), destination.getName());
                map(source.getTeams(), destination.getTeams());
            }
        });
    }
    // endregion

    // region User
    private static void UserToUserDto(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<User, UserDto>() {
            @Override
            protected void configure() {
                map(source.getId(), destination.getId());
                map(source.getUsername(), destination.getUsername());
                map(source.getMail(), destination.getMail());
                map(source.getRoles(), destination.getRoles());
            }
        });
    }
    // endregion

    // region Team
    private static void TeamToTeamDto(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<Team, TeamDto>() {
            @Override
            protected void configure() {
                map(source.getId(), destination.getId());
                map(source.getName(), destination.getName());
                map(source.getUsers(), destination.getUsers());
                map(source.getProject(), destination.getProject());
            }
        });
    }

    private static void TeamDtoToTeam(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<TeamDto, Team>() {
            @Override
            protected void configure() {
                map(source.getId(), destination.getId());
                map(source.getName(), destination.getName());
                map(source.getUsers(), destination.getUsers());
                map(source.getProject(), destination.getProject());
            }
        });
    }
    // endregion Team
}
