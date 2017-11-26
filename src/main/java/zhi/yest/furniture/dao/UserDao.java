package zhi.yest.furniture.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zhi.yest.furniture.domain.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
