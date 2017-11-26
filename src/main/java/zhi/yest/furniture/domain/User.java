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
    @GeneratedValue
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
