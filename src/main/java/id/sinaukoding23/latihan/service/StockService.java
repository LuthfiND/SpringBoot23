package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Stocks;
import id.sinaukoding23.latihan.model.dto.StockDTO;
import id.sinaukoding23.latihan.model.mapper.StockMapper;
import id.sinaukoding23.latihan.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository repository;

    @Transactional(readOnly = true)
    public List<StockDTO> findAll(){
        List<Stocks> data = repository.findAll();

        return StockMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public StockDTO createData(StockDTO param){
        Stocks data = StockMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return StockMapper.INSTANCE.entityToDto(data);
    }
    @Transactional
    public void updateStock(Integer productId, Integer quantity){
        Stocks data = repository.findByProduct_ProductId(productId);

        if (data != null){
            data.setQuantity(data.getQuantity() - quantity);

            repository.save(data);
        }
    }
}