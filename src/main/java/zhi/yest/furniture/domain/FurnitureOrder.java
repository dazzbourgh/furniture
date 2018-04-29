package zhi.yest.furniture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import zhi.yest.furniture.domain.furniture.FurniturePiece;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FurnitureOrder {
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(nullable = false)
    @OneToOne
    private FurniturePiece product;

    @JoinColumn(nullable = false)
    @ManyToOne
    private User user;

    private Boolean payed;
    private Boolean shipped;

    @Version
    private Integer version;
}
