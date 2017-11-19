package zhi.yest.furniture.domain.furniture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@NoArgsConstructor
@AllArgsConstructor
public abstract class FurniturePiece {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    protected Long id;

    @Getter
    @Setter
    @Column(unique = true)
    protected String title;

    @Getter
    @Setter
    protected String family;

    @Getter
    @Setter
    protected Float price;

    @Getter
    @Setter
    protected String color;
}
