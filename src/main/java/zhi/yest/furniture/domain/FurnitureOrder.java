package zhi.yest.furniture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zhi.yest.furniture.domain.furniture.FurniturePiece;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FurnitureOrder {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    Long id;

    @JoinColumn(nullable = false)
    @Getter
    @Setter
    @OneToOne
    FurniturePiece product;

    @JoinColumn(nullable = false)
    @Getter
    @Setter
    @ManyToOne
    User user;

    @Getter
    @Setter
    Boolean payed;

    @Getter
    @Setter
    Boolean shipped;
}
