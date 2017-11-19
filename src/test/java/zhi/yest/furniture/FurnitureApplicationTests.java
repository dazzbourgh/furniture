package zhi.yest.furniture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zhi.yest.furniture.dao.Dao;
import zhi.yest.furniture.dao.DaoImpl;
import zhi.yest.furniture.domain.furniture.Bed;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FurnitureApplicationTests {
	@Autowired
	Dao dao;
	@Test
	public void contextLoads() {
		Bed someBed = new Bed();
		someBed.setTitle("Generic Bed");
		dao.save(someBed, Bed.class);
		Bed bed = dao.getByTitle("Generic Bed", Bed.class)
				.orElse(null);
		assert bed != null;
	}
}
