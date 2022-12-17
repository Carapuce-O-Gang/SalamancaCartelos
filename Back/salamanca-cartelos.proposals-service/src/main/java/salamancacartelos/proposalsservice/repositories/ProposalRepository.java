package salamancacartelos.proposalsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salamancacartelos.proposalsservice.models.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    boolean existsById(Long id);
    boolean existsByTitle(String title);
}
