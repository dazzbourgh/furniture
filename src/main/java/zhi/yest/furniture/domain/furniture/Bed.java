package zhi.yest.furniture.domain.furniture;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("bed")
@EqualsAndHashCode(callSuper = true)
public class Bed extends FurniturePiece {
    @Getter
    @Setter
    private Integer personAmount;
}
