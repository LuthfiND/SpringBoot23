package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Brand;
import id.sinaukoding23.latihan.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository repository;

    @Transactional(readOnly = true)
    public List<Brand> findAll(){
        List<Brand> data = repository.findAllByIsDeleted(false);



        return data;
    }

    @Transactional
    public Brand createData(Brand param){
        param.setCreatedDate(new Date());
        param.setDeleted(false);
        return repository.save(param);
    }

    @Transactional
    public Brand updateData(Brand param, int id){
        Brand data = repository.findById(id).get();

        if (data != null){
            data.setBrandName(param.getBrandName() != null ? param.getBrandName() : data.getBrandName());
            data.setUpdatedDate(new Date());
            return repository.save(data);
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Brand data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}
