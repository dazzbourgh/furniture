package zhi.yest.furniture.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zhi.yest.furniture.domain.FurnitureOrder;

@Repository
public interface OrderDao extends CrudRepository<FurnitureOrder, Long> {
}
