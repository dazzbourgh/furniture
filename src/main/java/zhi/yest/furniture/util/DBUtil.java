package zhi.yest.furniture.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zhi.yest.furniture.dao.Dao;
import zhi.yest.furniture.dao.UserDao;
import zhi.yest.furniture.domain.User;
import zhi.yest.furniture.domain.furniture.Bed;
import zhi.yest.furniture.domain.furniture.Locker;
import zhi.yest.furniture.domain.furniture.Table;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class DBUtil {
    @Autowired
    Dao dao;
    @Autowired
    UserDao userDao;

    @PostConstruct
    public void fillDB() {
        addProducts();
        addUsers();
    }

    private void addProducts() {
        Bed someBed = new Bed();
        someBed.setTitle("Gulen Bed");
        someBed.setFamily("Gulen");
        someBed.setPersonAmount(2);
        someBed.setPrice(20F);
        someBed.setColor("Brown");
        someBed.setPictureUrl("https://www.myathath.com/thumbnail.ashx?Size=400&Ratio=1&Image=files/products/12_170517172744372_0.jpg");
        dao.save(someBed, Bed.class);
        Locker locker = new Locker();
        locker.setShelvesAmount(5);
        locker.setColor("Grey");
        locker.setFamily("Gulen");
        locker.setPrice(100F);
        locker.setTitle("Gulen Wardrobe");
        locker.setPictureUrl("https://www.visionconfort.com/media/catalog/product/cache/2/image/1200x1200/9df78eab33525d08d6e5fb8d27136e95/s/q/square1.png");
        dao.save(locker, Locker.class);
        Table table = new Table();
        table.setSize(5);
        table.setColor("Purple");
        table.setFamily("Generic");
        table.setPrice(1F);
        table.setTitle("Generic Table");
        table.setPictureUrl("http://www.oxfordgarden.com/products/images/thumb_HA28TA_1.jpg");
        dao.save(table, Table.class);
    }

    private void addUsers() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        user.setRole(User.Role.USER);
        User worker = new User();
        worker.setUsername("worker");
        worker.setPassword("password");
        worker.setRole(User.Role.WORKER);
        User manager = new User();
        manager.setUsername("manager");
        manager.setPassword("password");
        manager.setRole(User.Role.MANAGER);
        userDao.saveAll(Arrays.asList(user, worker, manager));
    }
}
