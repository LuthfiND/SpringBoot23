package id.sinaukoding23.latihan.controller;

        import id.sinaukoding23.latihan.model.Brand;
        import id.sinaukoding23.latihan.service.BrandService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService service;

    @GetMapping("/find-all")
    public ResponseEntity<?> getAllData() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<?> createDate(@RequestBody Brand param){
        Brand data = service.createData(param);

        if (data != null){
            return new ResponseEntity<>(data, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateData(@RequestBody Brand param,
                                        @RequestParam(name = "id") int id){
        Brand data = service.updateData(param, id);

        if (data != null){
            return new ResponseEntity<>(data, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteData(@PathVariable int id){
        if (service.deleteData(id)){
            return new ResponseEntity<>("Delete Sukses", HttpStatus.OK);
        }

        return new ResponseEntity<>("Delete Gagal", HttpStatus.BAD_REQUEST);
    }
}