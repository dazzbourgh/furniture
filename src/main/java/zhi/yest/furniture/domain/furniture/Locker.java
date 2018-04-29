package zhi.yest.furniture.domain.furniture;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("locker")
@EqualsAndHashCode(callSuper = true)
public class Locker extends FurniturePiece {
    @Getter
    @Setter
    private Integer shelvesAmount;
}
