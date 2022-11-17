package carapuceogang.salamancacartelos.authservice.controllers;

import carapuceogang.salamancacartelos.authservice.models.Project;
import carapuceogang.salamancacartelos.authservice.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/")
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.getProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProject(@PathVariable Long id) throws Exception {
        Project project = projectService.getProject(id);
        return ResponseEntity.ok(project);
    }

    @PostMapping("/")
    public ResponseEntity<?> createProject(@Valid @RequestBody Project project) throws Exception {
        Project savedProject = projectService.createProject(project);
        return ResponseEntity.ok(savedProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @Valid @RequestBody Project project) throws Exception {
        Project updatedProject = projectService.updateProject(id, project);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) throws Exception {
        boolean isDeleted = projectService.deleteProject(id);

        if (!isDeleted) {
            throw new Exception("something went wrong");
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
