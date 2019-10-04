package net.gabrielkovacs.coco.inventory.uc6;

import net.gabrielkovacs.coco.inventory.uc3.ProductSuplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DeliveryReportsRepository extends JpaRepository<ProductSuplier, Long> {

    @Query(value = "select ps.id from productsuplier ps, tradingenterprise te, tradinge_products  te_ps  " +
            "where te.id = te_ps.trading_enterprise_id and ps.id = te_ps.product_supplier_id and te.id = ?1", nativeQuery = true)
    List<Long> getAllProductSubliersByTradingEnterpriseId(long tradingEnterpriseId);

    @Query(value = "select datediff(day, po.ordering_date, po.delivery_date) as nr_days from productorder po " +
            "join orderentry oe on oe.productorderid = po.id    where  oe.productid in (select p.id from product p" +
            " where p.productsuplierid = ?1)", nativeQuery = true)
    List<Long> getNrDeliveryDaysPerProductForAProductSupplier(long productSupplierId);
}
