package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.*;
import id.sinaukoding23.latihan.model.dto.OrderDTO;
import id.sinaukoding23.latihan.model.enums.StatusOrder;
import id.sinaukoding23.latihan.model.mapper.*;
import id.sinaukoding23.latihan.model.Customer;
import id.sinaukoding23.latihan.model.Order;
import id.sinaukoding23.latihan.model.Staff;
import id.sinaukoding23.latihan.model.Store;
import id.sinaukoding23.latihan.model.mapper.CustomerMapper;
import id.sinaukoding23.latihan.model.mapper.StoreMapper;
import id.sinaukoding23.latihan.model.mapper.StaffMapper;
import id.sinaukoding23.latihan.repository.CustomerRepository;
import id.sinaukoding23.latihan.repository.OrderRepository;
import id.sinaukoding23.latihan.repository.OrderItemRepository;
import id.sinaukoding23.latihan.repository.StaffRepository;
import id.sinaukoding23.latihan.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import id.sinaukoding23.latihan.model.OrderItem;
import id.sinaukoding23.latihan.model.mapper.OrderMapper;


import java.util.Date;
import java.util.List;


import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private StockService stocksService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> data = repository.findAllByIsDeleted(false);

        return OrderMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public OrderDTO createData(OrderDTO param){
        Customer customer = CustomerMapper.INSTANCE.dtoToEntity(param.getCustomer());

        if (param.getCustomer() != null) {
            Customer resCustomer = null;

            if (customer.getCustomerId() != null) {
                resCustomer = customerRepository.getById(customer.getCustomerId());
            }
            customer.setCreatedDate(resCustomer != null ? resCustomer.getCreatedDate() : new Date());

            customer = customerRepository.save(customer);
        }

        Store store = StoreMapper.INSTANCE.dtoToEntity(param.getStore());

        if (param.getStore() != null) {
            Store resStore = null;

            if (store.getStoreId() != null) {
                resStore = storeRepository.getById(store.getStoreId());
            }
            customer.setCreatedDate(resStore != null ? resStore.getCreatedDate() : new Date());

            customer = customerRepository.save(customer);
        }

        Staff staff = StaffMapper.INSTANCE.dtoToEntity(param.getStaff());

        if (param.getStaff() != null) {
            Staff resStaff = null;

            if (store.getStoreId() != null) {
                resStaff = staffRepository.getById(staff.getStaffId());
            }
            staff.setCreatedDate(resStaff != null ? resStaff.getCreatedDate() : new Date());

            staff = staffRepository.save(staff);
        }

        Order data = OrderMapper.INSTANCE.dtoToEntity(param);
        data.setCustomer(customer);
        data.setStore(store);
        data.setStaff(staff);
        data.setCreatedDate(new Date());

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

    @Transactional
    public OrderDTO updateOrderStatus(OrderDTO param, Integer id){
        Order ref = repository.findById(id).get();

        if (ref != null){
            ref.setOrderStatus(param.getOrderStatus() != null ? param.getOrderStatus() : ref.getOrderStatus());

            ref = repository.save(ref);

            if (ref.getOrderStatus().equals(StatusOrder.PAYMENT)) {
                List<OrderItem> orderItem = orderItemRepository.findByOrder_OrderId(ref.getOrderId());

                for (OrderItem item : orderItem) {
                    stocksService.updateStock(item.getProduct().getProductId(), item.getQuantity());
                }
            }
        }

        return OrderMapper.INSTANCE.entityToDto(ref);
    }

}