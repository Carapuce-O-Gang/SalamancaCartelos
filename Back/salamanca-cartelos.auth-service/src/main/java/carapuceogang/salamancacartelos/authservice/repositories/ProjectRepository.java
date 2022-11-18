package carapuceogang.salamancacartelos.authservice.repositories;

import carapuceogang.salamancacartelos.authservice.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsById(Long id);
    boolean existsByName(String name);
}
