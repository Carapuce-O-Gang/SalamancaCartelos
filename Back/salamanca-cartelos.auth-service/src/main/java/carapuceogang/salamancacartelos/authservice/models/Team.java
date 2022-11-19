package carapuceogang.salamancacartelos.authservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
    name = "teams",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
    }
)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.PERSIST
    )
    @JoinTable(
        name = "teams_users",
        joinColumns = @JoinColumn(name = "team_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Team() {}

    public Team(Long id, String name, Set<User> users, Project project) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
