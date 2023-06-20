package carapuceogang.salamancacartelos.authservice.services;

import carapuceogang.salamancacartelos.authservice.dtos.ProjectDto;
import carapuceogang.salamancacartelos.authservice.models.Project;
import carapuceogang.salamancacartelos.authservice.repositories.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<ProjectDto> getProjects() {
        return toList(projectRepository.findAll());
    }

    public ProjectDto getProject(Long id) throws Exception {
        Optional<Project> project = projectRepository.findById(id);

        if (project.isEmpty()) {
            throw new Exception("project doesn't exist");
        }

        return toDto(project.get());
    }

    public ProjectDto createProject(ProjectDto project) throws Exception {
        if (project.getName() != null && projectRepository.existsByName(project.getName())) {
            throw new Exception("project name already exist");
        }

        Project savedProject = projectRepository.save(toModel(project));

        return toDto(savedProject);
    }

    public ProjectDto updateProject(Long id, ProjectDto project) throws Exception {
        if (!Objects.equals(id, project.getId())) {
            throw new Exception("id doesn't match");
        }

        if (!projectRepository.existsById(id)) {
            throw new Exception("project doesn't exist");
        }

        Optional<Project> p = projectRepository.findById(id);
        if (p.isEmpty()) {
            throw new Exception("project doesn't exist");
        }

        Project updatedProject = projectRepository.save(toModel(project));

        return toDto(updatedProject);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    // Mapping
    public List<ProjectDto> toList(List<Project> projects) {
        return MappingService.map(projects, ProjectDto.class, modelMapper);
    }

    public ProjectDto toDto(Project project) {
        return  MappingService.map(project, ProjectDto.class, modelMapper);
    }

    public Project toModel(ProjectDto project) {
        return  MappingService.map(project, Project.class, modelMapper);
    }
}
