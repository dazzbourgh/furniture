package zhi.yest.furniture.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class SessionUtil {
    @Autowired
    private EntityManagerFactory factory;

    public Session openSession() {
        SessionFactory sessionFactory = factory.unwrap(SessionFactory.class);
        return sessionFactory.openSession();
    }
}
