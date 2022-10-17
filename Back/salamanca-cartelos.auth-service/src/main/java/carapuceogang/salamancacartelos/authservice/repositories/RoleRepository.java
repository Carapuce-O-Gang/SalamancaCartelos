package carapuceogang.salamancacartelos.authservice.repositories;

import carapuceogang.salamancacartelos.authservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {}
