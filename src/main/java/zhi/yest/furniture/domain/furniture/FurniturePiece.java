package zhi.yest.furniture.domain.furniture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@NoArgsConstructor
@AllArgsConstructor
public abstract class FurniturePiece {
    @Id
    @Getter
    @Setter
    protected Long id;

    @Getter
    @Setter
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
