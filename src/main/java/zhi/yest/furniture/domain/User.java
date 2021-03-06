package zhi.yest.furniture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Column
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Column(unique = true)
    @Getter @Setter
    private String username;

    @Column
    @Getter @Setter
    private String password;

    @Column
    @Getter @Setter
    private Role role;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private Set<FurnitureOrder> orders;

    public enum Role {
        USER("USER"),
        MANAGER("MANAGER"),
        WORKER("WORKER");

        String role;

        Role(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return this.role;
        }
    }
}
