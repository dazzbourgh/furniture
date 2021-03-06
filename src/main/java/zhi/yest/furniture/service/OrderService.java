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
import java.util.Set;

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
        User user = getUser();
        FurniturePiece piece = dao.get(furnitureId, FurniturePiece.class);
        FurnitureOrder order = new FurnitureOrder();
        order.setProduct(piece);
        order.setUser(user);
        order.setPayed(false);
        order.setShipped(false);
        return orderDao.save(order);
    }

    public FurnitureOrder get(Long id) {
        return orderDao.findById(id).orElseThrow(NullPointerException::new);
    }

    public FurnitureOrder save(FurnitureOrder order) {
        return orderDao.save(order);
    }

    @Transactional
    public Set<FurnitureOrder> getOrders() {
        return orderDao.findByUser(getUser());
    }

    @Transactional
    public FurnitureOrder ship(Long orderId) {
        FurnitureOrder order = orderDao.findById(orderId).orElseThrow(NullPointerException::new);
        order.setShipped(true);
        return orderDao.save(order);
    }

    private User getUser() {
        org.springframework.security.core.userdetails.User details = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDao.findByUsername(details.getUsername());
    }
}
