package id.sinaukoding23.latihan.controller;

import id.sinaukoding23.latihan.common.RestResult;
import id.sinaukoding23.latihan.model.dto.CustomerDTO;
import id.sinaukoding23.latihan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/find-all")
    public RestResult getAllData(){
        List<CustomerDTO> data = service.findAll();

        return new RestResult(data, data.size() == 0 ? "Data tidak ditemukan" : "Menampilkan data", data.size(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public RestResult createDate(@RequestBody CustomerDTO param){
        CustomerDTO data = service.createData(param);

        if (data != null){
            return new RestResult(data, "Data Berhasil disimpan", HttpStatus.OK);
        }

        return new RestResult("Data gagal disimpan", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public RestResult updateData(@RequestBody CustomerDTO param,
                                 @RequestParam(name = "id") int id){
        CustomerDTO data = service.updateData(param, id);

        if (data != null){
            return new RestResult(data, "Data Berhasil diupdate", HttpStatus.OK);
        }

        return new RestResult("Data gagal diupdate", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public RestResult deleteData(@PathVariable int id){
        if (service.deleteData(id)){
            return new RestResult("Delete Sukses", HttpStatus.OK);
        }

        return new RestResult("Delete Gagal", HttpStatus.BAD_REQUEST);
    }
}