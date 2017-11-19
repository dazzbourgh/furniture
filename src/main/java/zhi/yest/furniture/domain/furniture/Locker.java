package zhi.yest.furniture.domain.furniture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("locker")
public class Locker extends FurniturePiece {
    @Getter
    @Setter
    private Integer shelvesAmount;
}
