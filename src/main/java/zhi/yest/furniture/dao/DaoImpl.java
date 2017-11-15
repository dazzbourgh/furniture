package zhi.yest.furniture.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import zhi.yest.furniture.domain.furniture.FurniturePiece;
import zhi.yest.furniture.util.HibernateUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class DaoImpl implements Dao {
    @Override
    public <T> Optional<T> get(Long id, Class<T> clazz) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        T t = session.get(clazz, id);
        session.close();
        return ofNullable(t);
    }

    @Override
    public <T> Optional<Long> save(T t, Class<T> clazz) {
        Optional<Transaction> tx = null;
        Long id = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = ofNullable(session.beginTransaction());
            id = (Long) session.save(t);
            tx.ifPresent(Transaction::commit);
        } catch (HibernateException e) {
            tx.ifPresent(Transaction::rollback);
            e.printStackTrace();
        }
        return ofNullable(id);
    }

    @Override
    public List<FurniturePiece> getByFamily(String family) {
        return null;
    }
}
