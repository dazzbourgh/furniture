package zhi.yest.furniture.domain.furniture;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("locker")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
public class Locker extends FurniturePiece {
    private Integer shelvesAmount;
}
