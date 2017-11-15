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
@DiscriminatorValue("table")
public class Table extends FurniturePiece {
    @Getter
    @Setter
    private Integer size;
}
