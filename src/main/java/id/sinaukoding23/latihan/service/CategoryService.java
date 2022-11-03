package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Category;
import id.sinaukoding23.latihan.model.dto.CategoryDTO;
import id.sinaukoding23.latihan.model.mapper.CategoryMapper;
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
    public List<CategoryDTO> findAll(){
        List<Category> data = repository.findAllByIsDeleted(false);

        return CategoryMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public CategoryDTO createData(CategoryDTO param){
        Category data = CategoryMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return CategoryMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public CategoryDTO updateData(CategoryDTO param, int id){
        Category data = repository.findById(id).get();

        if (data != null){
            data.setCategoryName(param.getCategoryName() != null ? param.getCategoryName() : data.getCategoryName());
            data.setUpdatedDate(new Date());

            return CategoryMapper.INSTANCE.entityToDto(repository.save(data));
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