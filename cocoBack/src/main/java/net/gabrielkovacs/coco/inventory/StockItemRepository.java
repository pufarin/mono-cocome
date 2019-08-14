package net.gabrielkovacs.coco.inventory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface StockItemRepository extends JpaRepository <StockItem, Long> {

    @Query(value="select * from stockitem where storeid = ?1", nativeQuery = true)
    List<StockItem> findAllByStoreId( long id);
    List<StockItem> findAll();

    

}