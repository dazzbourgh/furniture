package zhi.yest.furniture.domain.furniture;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("table")
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Table extends FurniturePiece {
    private Integer size;
}
