package zhi.yest.furniture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zhi.yest.furniture.dao.Dao;
import zhi.yest.furniture.domain.furniture.Bed;
import zhi.yest.furniture.domain.furniture.FurniturePiece;
import zhi.yest.furniture.domain.furniture.Locker;
import zhi.yest.furniture.domain.furniture.Table;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FurnitureApplicationTests {
    @Autowired
    Dao dao;

    @Test
    public void contextLoads() {
        Bed someBed = new Bed();
        someBed.setTitle("Queen's Bed");
        someBed.setFamily("Queen's");
        someBed.setPersonAmount(2);
        someBed.setPrice(20F);
        someBed.setColor("Grey");
        dao.save(someBed, Bed.class);
        Locker locker = new Locker();
        locker.setShelvesAmount(5);
        locker.setColor("Grey");
        locker.setFamily("Queen's");
        locker.setPrice(100F);
        locker.setTitle("Queen's Locker");
        dao.save(locker, Locker.class);
        Table table = new Table();
        table.setSize(5);
        table.setColor("Purple");
        table.setFamily("Generic");
        table.setPrice(1F);
        table.setTitle("Generic Table");
        dao.save(table, Table.class);
    }
}
