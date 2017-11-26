package zhi.yest.furniture.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zhi.yest.furniture.domain.FurnitureOrder;
import zhi.yest.furniture.domain.User;

import java.util.Set;

@Repository
public interface OrderDao extends CrudRepository<FurnitureOrder, Long> {
    Set<FurnitureOrder> findByUser(User user);

    Set<FurnitureOrder> findByShipped(Boolean shipped);

    default Set<FurnitureOrder> findAllNotShipped() {
        return findByShipped(false);
    }
}
