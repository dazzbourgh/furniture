package zhi.yest.furniture.domain.furniture;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("bed")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
public class Bed extends FurniturePiece {
    private Integer personAmount;
}
