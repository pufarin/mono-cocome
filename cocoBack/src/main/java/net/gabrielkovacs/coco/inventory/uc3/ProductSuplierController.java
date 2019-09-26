package net.gabrielkovacs.coco.inventory.uc3;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.gabrielkovacs.coco.inventory.OrderEntry;
import net.gabrielkovacs.coco.inventory.Product;
import net.gabrielkovacs.coco.inventory.ProductOrder;
import net.gabrielkovacs.coco.inventory.Store;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class ProductSuplierController {

    private ProductRepository productRepository;
    private OrderEntryRepository orderEntryRepository;
    private ProductOrderRepository productOrderRepository;

    public ProductSuplierController(ProductRepository productRepository, OrderEntryRepository orderEntryRepository,ProductOrderRepository productOrderRepository){
        this.productRepository = productRepository;
        this.orderEntryRepository = orderEntryRepository;
        this.productOrderRepository = productOrderRepository;
    }

    @GetMapping("products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("stockitems/store/{storeId}/lowstock")
    public List<LowStockProduct> getAllProductsWithLowStock(@PathVariable long storeId){
        return productRepository.getProductsUnderMinStock(storeId);
    }

/*
    @PostMapping("store/{storeId}/order")
    void orderProduct(@RequestBody OrderEntry orderEntry, @PathVariable Long storeId){
        ProductOrder productOrder = new ProductOrder(); // is it possible to fix this?
        Store store = new Store(storeId);
        Date orderDate = new java.sql.Date(System.currentTimeMillis());
         
        
        productOrder.setOrderingDate(orderDate);
        productOrder.setStore(store);
        productOrder =  productOrderRepository.save(productOrder);
      
        //orderEntry.setId(99999);
        orderEntry.setProductOrder(productOrder);
        orderEntryRepository.save(orderEntry);
        
                                      
    }
*/
    @PostMapping("store/{storeId}/order")
    public OrderEntry  orderProduct(@RequestBody OrderEntry orderEntry, @PathVariable Long storeId){
        ProductOrder productOrder = new ProductOrder(); // is it possible to fix this?
        Store store = new Store(storeId);

        Date orderDate = new java.sql.Date(System.currentTimeMillis());


        productOrder.setOrderingDate(orderDate);
        productOrder.setStore(store);
        productOrder =  productOrderRepository.save(productOrder);

        //orderEntry.setId(99999);
        orderEntry.setProductOrder(productOrder);
        return orderEntryRepository.save(orderEntry);

    }

}