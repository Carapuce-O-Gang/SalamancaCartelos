package carapuceogang.salamancacartelos.authservice.services;

import carapuceogang.salamancacartelos.authservice.dtos.ProjectDto;
import carapuceogang.salamancacartelos.authservice.models.Project;
import carapuceogang.salamancacartelos.authservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(Long id) throws Exception {
        Optional<Project> project = projectRepository.findById(id);

        if (project.isEmpty()) {
            throw new Exception("project doesn't exist");
        }

        return project.get();
    }

    public Project createProject(ProjectDto projectDto) throws Exception {
        if (projectDto.getName() != null && projectRepository.existsByName(projectDto.getName())) {
            throw new Exception("project name already exist");
        }

        Project project = new Project();
        project.setName(projectDto.getName());
        project.setTeams(projectDto.getTeams());

        return projectRepository.save(project);
    }

    public Project updateProject(Long id, ProjectDto projectDto) throws Exception {
        if (!projectRepository.existsById(id)) {
            throw new Exception("project doesn't exist");
        }

        Optional<Project> p = projectRepository.findById(id);

        if (p.isEmpty()) {
            throw new Exception("project doesn't exist");
        }

        Project project = p.get();
        project.setName(projectDto.getName());
        project.setTeams(projectDto.getTeams());

        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
