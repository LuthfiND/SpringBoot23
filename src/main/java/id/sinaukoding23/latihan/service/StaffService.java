package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Staff;
import id.sinaukoding23.latihan.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository repository;

    @Transactional(readOnly = true)
    public List<Staff> findAll() {
        List<Staff> data = repository.findAllByIsDeleted(false);


        return data;
    }

    @Transactional
    public Staff createData(Staff param) {
        param.setCreatedDate(new Date());
        param.setDeleted(false);
        return repository.save(param);
    }

    @Transactional
    public Staff updateData(Staff param, int id) {
        Staff data = repository.findById(id).get();

        if (data != null) {
            data.setFirstName(param.getFirstName() != null ? param.getFirstName() : data.getFirstName());
            data.setLastName(param.getLastName() != null ? param.getLastName() : data.getLastName());
            data.setPhone(param.getPhone() != null ? param.getPhone() : data.getPhone());
            data.setEmail(param.getEmail() != null ? param.getEmail() : data.getEmail());
            data.setActive(param.getActive() != null ? param.getActive() : data.getActive());
            data.setUpdatedDate(new Date());

            return repository.save(data);
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