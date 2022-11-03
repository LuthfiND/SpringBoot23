package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Brand;
import id.sinaukoding23.latihan.model.dto.BrandDTO;
import id.sinaukoding23.latihan.model.mapper.BrandMapper;
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
    public List<BrandDTO> findAll(){
        List<Brand> data = repository.findAllByIsDeleted(false);

        return BrandMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public BrandDTO createData(BrandDTO param){
        Brand data = BrandMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return BrandMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public BrandDTO updateData(BrandDTO param, int id){
        Brand data = repository.findById(id).get();

        if (data != null){
            data.setBrandName(param.getBrandName() != null ? param.getBrandName() : data.getBrandName());
            data.setUpdatedDate(new Date());

            return BrandMapper.INSTANCE.entityToDto(repository.save(data));
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