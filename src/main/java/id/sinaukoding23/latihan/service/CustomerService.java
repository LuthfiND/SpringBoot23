package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Customer;
import id.sinaukoding23.latihan.model.dto.CustomerDTO;
import id.sinaukoding23.latihan.model.mapper.CustomerMapper;
import id.sinaukoding23.latihan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAll(){
        List<Customer> data = repository.findAllByIsDeleted(false);

        return CustomerMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public CustomerDTO createData(CustomerDTO param){
        Customer data = CustomerMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return CustomerMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public CustomerDTO updateData(CustomerDTO param, int id){
        Customer data = repository.findById(id).get();

        if (data != null){
            data.setFirstName(param.getFirstName() != null ? param.getFirstName() : data.getFirstName());
            data.setLastName(param.getLastName() != null ? param.getLastName() : data.getLastName());
            data.setPhone(param.getPhone() != null ? param.getPhone() : data.getPhone());
            data.setEmail(param.getEmail() != null ? param.getEmail() : data.getEmail());
            data.setStreet(param.getStreet() != null ? param.getStreet() : data.getStreet());
            data.setCity(param.getCity() != null ? param.getCity() : data.getCity());
            data.setZipCode(param.getZipCode() != null ? param.getZipCode() : data.getZipCode());
            data.setState(param.getState() != null ? param.getState() : data.getState());
            data.setUpdatedDate(new Date());

            return CustomerMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Customer data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}