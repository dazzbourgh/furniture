package zhi.yest.furniture.dao;

import zhi.yest.furniture.domain.furniture.FurniturePiece;

import java.util.List;
import java.util.Optional;

public interface Dao {
    <T> Optional<T> get(Long id, Class<T> clazz);
    <T> Optional<Long> save(T t, Class<T> clazz);
    List<FurniturePiece> getByFamily(String family);
}
