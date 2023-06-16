package carapuceogang.salamancacartelos.proposalsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carapuceogang.salamancacartelos.proposalsservice.models.Discussion;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    boolean existsById(Long id);
}
