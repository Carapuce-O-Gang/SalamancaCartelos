package carapuceogang.salamancacartelos.authservice.controllers;

import carapuceogang.salamancacartelos.authservice.models.ErrorResponse;
import carapuceogang.salamancacartelos.authservice.models.Project;
import carapuceogang.salamancacartelos.authservice.models.SignUpRequest;
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
    public ResponseEntity<?> getProject(@PathVariable Long id) {
        try {
            Project project = projectService.getProject(id);
            return ResponseEntity.ok(project);
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity
                .badRequest()
                .body(error);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createProject(@Valid @RequestBody Project project) {
        try {
            Project savedProject = projectService.createProject(project);
            return ResponseEntity.ok(savedProject);

        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity
                .badRequest()
                .body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @Valid @RequestBody Project project) {
        try {
            Project updatedProject = projectService.updateProject(id, project);
            return ResponseEntity.ok(updatedProject);
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity
                .badRequest()
                .body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
