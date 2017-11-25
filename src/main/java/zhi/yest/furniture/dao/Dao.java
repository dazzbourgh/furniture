package zhi.yest.furniture.dao;

import zhi.yest.furniture.domain.furniture.FurniturePiece;

import java.util.List;
import java.util.Optional;

public interface Dao {
    <T extends FurniturePiece> T get(Long id, Class<T> clazz);

    List<FurniturePiece> getAll();

    <T extends FurniturePiece> Long save(T t, Class<T> clazz);

    <T extends FurniturePiece> boolean update(T t, Class<T> clazz);

    <T extends FurniturePiece> boolean delete(T t, Class<T> clazz);

    List<FurniturePiece> getByFamily(String family);

    <T extends FurniturePiece> List<T> getByFamily(String family, Class<T> clazz);

    <T extends FurniturePiece> Optional<T> getByTitle(String name, Class<T> clazz);
}
