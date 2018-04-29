package zhi.yest.furniture.domain.furniture;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("table")
@EqualsAndHashCode(callSuper = true)
public class Table extends FurniturePiece {
    @Getter
    @Setter
    private Integer size;
}
