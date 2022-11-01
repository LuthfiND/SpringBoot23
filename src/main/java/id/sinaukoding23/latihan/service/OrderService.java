package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Order;
import id.sinaukoding23.latihan.model.dto.OrderDTO;
import id.sinaukoding23.latihan.model.mapper.OrderMapper;
import id.sinaukoding23.latihan.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> data = repository.findAllByIsDeleted(false);

        return OrderMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public OrderDTO createData(OrderDTO param){
        Order data = OrderMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return OrderMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public OrderDTO updateData(OrderDTO param, int id){
        Order data = repository.findById(id).get();

        if (data != null){
            data.setOrderStatus(param.getOrderStatus() != null ? param.getOrderStatus() : data.getOrderStatus());
            data.setOrderDate(param.getOrderDate() != null ? param.getOrderDate() : data.getOrderDate());
            data.setRequiredDate(param.getRequiredDate() != null ? param.getRequiredDate() : data.getRequiredDate());
            data.setShippedDate(param.getShippedDate() != null ? param.getShippedDate() : data.getShippedDate());
            data.setUpdatedDate(new Date());

            return OrderMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }
    @Transactional
    public boolean deleteData(int id){
       Order data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}
