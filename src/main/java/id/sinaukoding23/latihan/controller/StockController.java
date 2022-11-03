package id.sinaukoding23.latihan.controller;

import id.sinaukoding23.latihan.common.RestResult;
import id.sinaukoding23.latihan.model.dto.StockDTO;
import id.sinaukoding23.latihan.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService service;

    @GetMapping("/find-all")
    public RestResult getAllData(){
        List<StockDTO> data = service.findAll();

        return new RestResult(data, data.size() == 0 ? "Data tidak ditemukan" : "Menampilkan data", data.size(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public RestResult createData(@RequestBody StockDTO param){
        StockDTO data = service.createData(param);

        if (data != null){
            return new RestResult(data, "Data Berhasil disimpan", HttpStatus.OK);
        }

        return new RestResult("Data gagal disimpan", HttpStatus.BAD_REQUEST);
    }

}