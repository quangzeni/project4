package ra.service;

import ra.model.Order;
import ra.model.OrderDetail;
import ra.model.OrderStatus;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order findById(Long orderId);

    boolean createOrder(Order order);

    boolean updateOrderStatus(Long orderId, OrderStatus newStatus);

    boolean cancelOrder(Long orderId);

    List<OrderDetail> getOrderDetailsByOrderId(Long orderId);
}

