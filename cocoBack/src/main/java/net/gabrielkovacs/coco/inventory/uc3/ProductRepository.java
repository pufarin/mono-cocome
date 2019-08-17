package net.gabrielkovacs.coco.inventory.uc3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.gabrielkovacs.coco.inventory.Product;

interface ProductRepository extends JpaRepository<Product, Long>{

    Product getProductById(long id);
    List<Product> findAll();

    @Query(value = "select s.storeid, p.name, s.amount, s.minstock from stockitem s, product p where s.amount < s.minstock and p.id = s.productid and s.storeid=?1", nativeQuery = true)
    List<LowStockProduct> getProductsUnderMinStock(long storeId);
}