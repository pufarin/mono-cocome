package net.gabrielkovacs.coco.inventory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StockItemRepository extends JpaRepository <StockItem, Long> {

    @Query(value="select * from stockitem where storeid = ?1", nativeQuery = true)
    List<StockItem> findAllByStoreId( long id);
    
    @Query(value="select * from stockitem where storeid = ?1 and productid = ?2", nativeQuery = true)
    StockItem findAllByStoreIdAndProductId( long storeid, long productid);
    
    List<StockItem> findAll();

    

}