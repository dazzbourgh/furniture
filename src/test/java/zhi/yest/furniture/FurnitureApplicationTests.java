package zhi.yest.furniture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zhi.yest.furniture.dao.Dao;
import zhi.yest.furniture.domain.furniture.Bed;
import zhi.yest.furniture.domain.furniture.FurniturePiece;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FurnitureApplicationTests {
    @Autowired
    Dao dao;

    @Test
    public void contextLoads() {
        Bed someBed = new Bed();
        someBed.setTitle("Generic Bed");
        someBed.setFamily("Family");
        someBed.setPersonAmount(2);
        dao.save(someBed, Bed.class);
        Bed bed = (Bed) dao.getByFamily("Family").get(0);
        bed.setTitle("New Title");
        dao.update(bed, Bed.class);
        bed = dao.getByTitle("New Title", Bed.class)
                .orElse(null);
        Bed fakeBed = new Bed();
        fakeBed.setId(17L);
        dao.delete(fakeBed, Bed.class);
        dao.delete(bed, Bed.class);
        assert dao.get(1L, Bed.class) == null;
    }
}
