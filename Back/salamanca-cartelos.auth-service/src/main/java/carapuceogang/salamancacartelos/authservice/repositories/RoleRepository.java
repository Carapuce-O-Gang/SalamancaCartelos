package carapuceogang.salamancacartelos.authservice.repositories;

import carapuceogang.salamancacartelos.authservice.models.ERole;
import carapuceogang.salamancacartelos.authservice.models.Role;
import carapuceogang.salamancacartelos.authservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
