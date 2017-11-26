package zhi.yest.furniture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import zhi.yest.furniture.dao.Dao;
import zhi.yest.furniture.dao.OrderDao;
import zhi.yest.furniture.dao.UserDao;
import zhi.yest.furniture.domain.FurnitureOrder;
import zhi.yest.furniture.domain.User;
import zhi.yest.furniture.domain.furniture.FurniturePiece;

import javax.transaction.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private Dao dao;
    @Autowired
    private UserDao userDao;

    @Transactional
    public FurnitureOrder createOrder(Long furnitureId) {
        org.springframework.security.core.userdetails.User details = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findByUsername(details.getUsername());
        FurniturePiece piece = dao.get(furnitureId, FurniturePiece.class);
        FurnitureOrder order = new FurnitureOrder();
        order.setProduct(piece);
        order.setUser(user);
        order.setShipped(false);
        return orderDao.save(order);
    }
}
