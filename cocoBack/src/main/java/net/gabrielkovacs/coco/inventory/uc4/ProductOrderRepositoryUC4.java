package net.gabrielkovacs.coco.inventory.uc4;

import net.gabrielkovacs.coco.inventory.OrderEntry;
import net.gabrielkovacs.coco.inventory.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductOrderRepositoryUC4 extends JpaRepository<ProductOrder, Long> {

    @Query(value = "select * from productorder po where po.id = (select productorderid from orderentry o where o.id=?1)", nativeQuery = true)
    Optional<ProductOrder> getProductOrderByOrderEntryId(long orderEntryId);

    @Query(value = "select * from orderentry where id = ?1", nativeQuery = true)
    OrderEntry getProductId(long orderEntryId);

}
