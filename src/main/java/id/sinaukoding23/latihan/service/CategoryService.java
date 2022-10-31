package id.sinaukoding23.latihan.service;


import id.sinaukoding23.latihan.model.Category;

import id.sinaukoding23.latihan.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<Category> findAll(){
        List<Category> data = repository.findAllByIsDeleted(false);



        return data;
    }

    @Transactional
    public Category createData(Category param){
        param.setCreatedDate(new Date());
        param.setDeleted(false);
        return repository.save(param);
    }

    @Transactional
    public Category updateData(Category param, int id){
        Category data = repository.findById(id).get();

        if (data != null){
            data.setCategoryName(param.getCategoryName() != null ? param.getCategoryName() : data.getCategoryName());
            data.setUpdatedDate(new Date());
            return repository.save(data);
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Category data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}

