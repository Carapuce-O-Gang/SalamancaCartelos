package carapuceogang.salamancacartelos.authservice.repositories;

import carapuceogang.salamancacartelos.authservice.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsById(Long id);
    boolean existsByName(String name);
}
