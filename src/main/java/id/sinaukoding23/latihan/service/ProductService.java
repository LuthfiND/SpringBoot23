package id.sinaukoding23.latihan.service;


import id.sinaukoding23.latihan.model.Product;
import id.sinaukoding23.latihan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        List<Product> data = repository.findAllByIsDeleted(false);


        return data;
    }

    @Transactional
    public Product createData(Product param) {
        param.setCreatedDate(new Date());
        param.setDeleted(false);
        return repository.save(param);
    }

    @Transactional
    public Product updateData(Product param, int id) {
        Product data = repository.findById(id).get();

        if (data != null) {
            data.setProductName(param.getProductName() != null ? param.getProductName() : data.getProductName());
            data.setModelYear(param.getModelYear() != null ? param.getModelYear() : data.getModelYear());
            data.setListPrice(param.getListPrice() != null ? param.getListPrice() : data.getListPrice());
            data.setUpdatedDate(new Date());

            return repository.save(data);
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id) {
        Product data = repository.findById(id).get();

        if (data != null) {
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}