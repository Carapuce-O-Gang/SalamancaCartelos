package salamancacartelos.proposalsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salamancacartelos.proposalsservice.models.Discuss;

@Repository
public interface DiscussRepository extends JpaRepository<Discuss, Long> {
    boolean existsById(Long id);
}
