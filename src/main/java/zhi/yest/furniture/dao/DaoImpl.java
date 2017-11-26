package zhi.yest.furniture.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zhi.yest.furniture.domain.furniture.FurniturePiece;
import zhi.yest.furniture.util.SessionUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Repository
public class DaoImpl implements Dao {
    @Autowired
    private SessionUtil util;

    @Override
    public <T extends FurniturePiece> T get(Long id, Class<T> clazz) {
        Session session = util.openSession();
        T t = session.get(clazz, id);
        session.close();
        return t;
    }

    @Override
    public List<FurniturePiece> getAll() {
        try (Session session = util.openSession()) {
            Query query = session.createQuery("select f from FurniturePiece f", FurniturePiece.class);
            return (List<FurniturePiece>) query.getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public <T extends FurniturePiece> Long save(T t, Class<T> clazz) {
        Optional<Transaction> tx = Optional.empty();
        Long id = null;

        try (Session session = util.openSession()) {
            tx = ofNullable(session.beginTransaction());
            id = (Long) session.save(t);
            tx.ifPresent(Transaction::commit);
        } catch (HibernateException e) {
            tx.ifPresent(Transaction::rollback);
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public <T extends FurniturePiece> boolean update(T t, Class<T> clazz) {
        Optional<Transaction> tx = Optional.empty();
        boolean result;

        try (Session session = util.openSession()) {
            tx = ofNullable(session.beginTransaction());
            result = session.get(clazz, t.getId()) != null;
            if (result) {
                T managed = session.contains(t) ? t : (T) session.merge(t);
                session.update(managed);
            }
            tx.ifPresent(Transaction::commit);
        } catch (HibernateException e) {
            tx.ifPresent(Transaction::rollback);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public <T extends FurniturePiece> boolean delete(T t, Class<T> clazz) {
        Optional<Transaction> tx = Optional.empty();
        boolean result;

        try (Session session = util.openSession()) {
            tx = ofNullable(session.beginTransaction());
            result = session.get(clazz, t.getId()) != null;
            if (result) {
                T managed = session.contains(t) ? t : (T) session.merge(t);
                session.delete(managed);
            }
            tx.ifPresent(Transaction::commit);
        } catch (HibernateException e) {
            tx.ifPresent(Transaction::rollback);
            e.printStackTrace();
            return false;
        }
        return result;
    }

    @Override
    public List<FurniturePiece> getByFamily(String family) {
        try (Session session = util.openSession()) {
            Query query = session.createQuery("select f from FurniturePiece f where family=:family", FurniturePiece.class);
            query.setParameter("family", family);
            return (List<FurniturePiece>) query.getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public <T extends FurniturePiece> List<T> getByFamily(String family, Class<T> clazz) {
        try (Session session = util.openSession()) {
            Query query = session.createQuery("select t from " + clazz.getSimpleName() + " t where family=:family", clazz);
            query.setParameter("family", family);
            return (List<T>) query.getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public <T extends FurniturePiece> Optional<T> getByTitle(String title, Class<T> clazz) {
        try (Session session = util.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
            Root<T> root = criteriaQuery.from(clazz);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.equal(root.get("title"), title));
            return session.createQuery(criteriaQuery).uniqueResultOptional();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
