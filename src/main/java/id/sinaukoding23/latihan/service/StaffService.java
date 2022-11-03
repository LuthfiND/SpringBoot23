package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Customer;
import id.sinaukoding23.latihan.model.Staff;
import id.sinaukoding23.latihan.model.Store;
import id.sinaukoding23.latihan.model.dto.StaffDTO;
import id.sinaukoding23.latihan.model.dto.StoreDTO;
import id.sinaukoding23.latihan.model.mapper.CustomerMapper;
import id.sinaukoding23.latihan.model.mapper.ProductMapper;
import id.sinaukoding23.latihan.model.mapper.StaffMapper;
import id.sinaukoding23.latihan.model.mapper.StoreMapper;
import id.sinaukoding23.latihan.repository.BrandRepository;
import id.sinaukoding23.latihan.repository.StaffRepository;
import id.sinaukoding23.latihan.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository repository;

    @Autowired
    private StoreRepository storeRepository;


    @Transactional(readOnly = true)
    public List<StaffDTO> findAll(){
        List<Staff> data = repository.findAllByIsDeleted(false);

        return StaffMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public StaffDTO createData(StaffDTO param){
        Store store = StoreMapper.INSTANCE.dtoToEntity(param.getStore());

        if (param.getStore() != null) {
            Store resStore = null;

            if (store.getStoreId() != null) {
                resStore = storeRepository.getById(store.getStoreId());
            }
            store.setCreatedDate(resStore != null ? resStore.getCreatedDate() : new Date());

            store = storeRepository.save(store);
        }
        Staff data = StaffMapper.INSTANCE.dtoToEntity(param);
        data.setStore(store);
        data = repository.save(data);

        return StaffMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public StaffDTO updateData(StaffDTO param, int id){
        Staff data = repository.findById(id).get();

        if (data != null) {
            data.setFirstName(param.getFirstName() != null ? param.getFirstName() : data.getFirstName());
            data.setLastName(param.getLastName() != null ? param.getLastName() : data.getLastName());
            data.setPhone(param.getPhone() != null ? param.getPhone() : data.getPhone());
            data.setEmail(param.getEmail() != null ? param.getEmail() : data.getEmail());
            data.setActive(param.getActive() != null ? param.getActive() : data.getActive());
            data.setUpdatedDate(new Date());

            return StaffMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id) {
        Staff data = repository.findById(id).get();

        if (data != null) {
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}