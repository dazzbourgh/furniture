package zhi.yest.furniture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Column(unique = true, nullable = false)
    @Id
    @Getter @Setter
    private Long id;

    @Column
    @Getter @Setter
    private String username;

    @Column
    @Getter @Setter
    private String password;

    @Column
    @Getter @Setter
    private Role role;

    private enum Role {
        USER("user"),
        MANAGER("manager"),
        WORKER("worker"),
        ADMIN("admin");

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
