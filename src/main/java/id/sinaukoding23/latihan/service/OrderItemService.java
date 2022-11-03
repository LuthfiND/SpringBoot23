package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Order;
import id.sinaukoding23.latihan.model.Order;
import id.sinaukoding23.latihan.model.OrderItem;
import id.sinaukoding23.latihan.model.Product;
import id.sinaukoding23.latihan.model.dto.OrderDTO;
import id.sinaukoding23.latihan.model.dto.OrderItemDTO;
import id.sinaukoding23.latihan.model.mapper.OrderMapper;
import id.sinaukoding23.latihan.model.mapper.OrderItemMapper;
import id.sinaukoding23.latihan.model.mapper.OrderMapper;
import id.sinaukoding23.latihan.model.mapper.ProductMapper;
import id.sinaukoding23.latihan.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderItemDTO> findAll(){
        List<OrderItem> data = repository.findAllByIsDeleted(false);

        return OrderItemMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public OrderItemDTO createData(OrderItemDTO param){
        
        Order order = OrderMapper.INSTANCE.dtoToEntity(param.getOrder());

        if (param.getOrder() != null) {
            Order resOrder = null;

            if (order.getOrderId() != null) {
                resOrder = orderRepository.findById(order.getOrderId()).get();
            }
            order.setCreatedDate(resOrder != null ? resOrder.getCreatedDate() : new Date());

            order = orderRepository.save(order);
        }

        Product product = ProductMapper.INSTANCE.dtoToEntity(param.getProduct());

        if (param.getProduct() != null) {
            Product resProduct = null;

            if (product.getProductId() != null) {
                resProduct = productRepository.findById(product.getProductId()).get();
            }
            product.setCreatedDate(resProduct != null ? resProduct.getCreatedDate() : new Date());

            product =  productRepository.save( product);
        }
        
        OrderItem data = OrderItemMapper.INSTANCE.dtoToEntity(param);
        data.setOrder(order);
        data.setProduct(product);
        data = repository.save(data);

        return OrderItemMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public OrderItemDTO updateData(OrderItemDTO param, int id){
        OrderItem data = repository.findById(id).get();

        if (data != null){

            data.setUpdatedDate(new Date());

            return OrderItemMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        OrderItem data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }

}