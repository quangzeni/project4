package ra.service;

import ra.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findAll();

    OrderDetail findById(Long orderDetailId);

    boolean createOrderDetail(OrderDetail orderDetail);

    boolean deleteOrderDetail(Long orderDetailId);
}

