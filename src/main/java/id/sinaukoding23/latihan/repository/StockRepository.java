package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Stocks;
import id.sinaukoding23.latihan.model.embeddables.StocksKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stocks, Integer> {
    Stocks findByProduct_ProductId(Integer id);
}