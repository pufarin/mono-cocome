package net.gabrielkovacs.coco.inventory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import net.gabrielkovacs.coco.inventory.uc5.StockItemReport;

@CrossOrigin(origins = "http://localhost:4200")
public interface StockItemRepository extends JpaRepository <StockItem, Long> {

    @Query(value="select * from stockitem where storeid = ?1", nativeQuery = true)
    List<StockItem> findAllByStoreId( long id);
    
    @Query(value="select * from stockitem where storeid = ?1 and productid = ?2", nativeQuery = true)
    StockItem findAllByStoreIdAndProductId( long storeid, long productid);

    @Query(value="select si.id, p.name, si.amount, si.minstock, si.maxstock  from stockitem si, product p where si.productid = p.id and si.storeid=?1", nativeQuery = true)
    List<StockItemReport> getReportDataForStore( long storeid);

    StockItem getStockItemById(long id);
    List<StockItem> findAll();

}