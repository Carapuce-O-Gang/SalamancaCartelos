package carapuceogang.salamancacartelos.authservice.services;

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

        if (!project.isPresent()) {
            throw new Exception("project doesn't exist");
        }

        return project.get();
    }

    public Project createProject(Project project) throws Exception {
        if (project.getId() != null && projectRepository.existsById(project.getId())) {
            throw new Exception("project already exist");
        }

        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project project) throws Exception {
        if (id != project.getId()) {
            throw new Exception("project id doesn't match");
        }

        if (!projectRepository.existsById(id)) {
            throw new Exception("project doesn't exist");
        }

        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
