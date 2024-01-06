package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.model.Order;
import ra.model.OrderDetail;
import ra.model.OrderStatus;
import ra.repository.OrderDetailRepository;
import ra.repository.OrderRepository;
import ra.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    @Transactional
    public boolean createOrder(Order order) {
        return true;
    }

    @Override
    @Transactional
    public boolean updateOrderStatus(Long orderId, OrderStatus newStatus) {
        return true;
    }

    @Override
    @Transactional
    public boolean cancelOrder(Long orderId) {
        return true;
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
        return null;
    }

    //@Override
//    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
//        return orderDetailRepository.findByOrderId(orderId);
//        //Cannot resolve method 'findByOrderId' in 'OrderDetailRepository'
//    }
}

