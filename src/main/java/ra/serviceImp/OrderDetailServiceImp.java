package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.model.OrderDetail;
import ra.repository.OrderDetailRepository;
import ra.service.OrderDetailService;

import java.util.List;

@Service
public class OrderDetailServiceImp implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail findById(Long orderDetailId) {
        return orderDetailRepository.findById(orderDetailId).orElse(null);
    }

    @Override
    @Transactional
    public boolean createOrderDetail(OrderDetail orderDetail) {
        return true;
    }

    @Override
    @Transactional
    public boolean deleteOrderDetail(Long orderDetailId) {
        return true;
    }
}

