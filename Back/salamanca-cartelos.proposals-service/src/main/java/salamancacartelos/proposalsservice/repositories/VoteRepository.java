package salamancacartelos.proposalsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salamancacartelos.proposalsservice.models.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsById(Long id);
    boolean existsByUserId(Long userId);
}
