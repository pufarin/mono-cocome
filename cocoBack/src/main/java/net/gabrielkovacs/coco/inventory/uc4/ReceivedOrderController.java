package net.gabrielkovacs.coco.inventory.uc4;

import net.gabrielkovacs.coco.inventory.OrderEntry;
import net.gabrielkovacs.coco.inventory.ProductOrder;
import net.gabrielkovacs.coco.inventory.StockItem;
import net.gabrielkovacs.coco.inventory.StockItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReceivedOrderController{

   private ProductOrderRepositoryUC4 productOrderRepositoryUC4;
   private StockItemRepository stockItemRepository;
   private OrderEntryRepositoryUC4 orderEntryRepositoryUC4;

    public ReceivedOrderController(ProductOrderRepositoryUC4 productOrderRepositoryUC4,
                                   StockItemRepository stockItemRepository,
                                   OrderEntryRepositoryUC4 orderEntryRepositoryUC4){
        this.productOrderRepositoryUC4 = productOrderRepositoryUC4;
        this.stockItemRepository = stockItemRepository;
        this.orderEntryRepositoryUC4 = orderEntryRepositoryUC4;
    }

    @PutMapping("product-order/{orderId}")
    ResponseEntity<?> receivedOrder(@RequestBody ReceivedOrder receivedOrder, @PathVariable Long orderId){

        Optional<ProductOrder> queryResult = productOrderRepositoryUC4.getProductOrderByOrderEntryId(orderId);
        if(!queryResult.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            queryResult.ifPresent(productOrder -> {
                productOrder.setDeliveryDate(receivedOrder.getDeliveryDate());
                productOrderRepositoryUC4.save(productOrder);
            });

            Optional<OrderEntry> orderEntry = orderEntryRepositoryUC4.findById(orderId);
            long productId = orderEntry.get().getProductId();
            int orderedAmount = orderEntry.get().getAmount();

            StockItem stockItemQueryResult = stockItemRepository.findAllByStoreIdAndProductId(queryResult.get().getStoreId(), productId );
            int existingAmount = stockItemQueryResult.getAmount();
            stockItemQueryResult.setAmount(existingAmount + orderedAmount);
            stockItemRepository.save(stockItemQueryResult);
            return new ResponseEntity<>(HttpStatus.OK);
            //return new ResponseEntity<>(stockItemQueryResult.toString(),HttpStatus.OK);
        }
    }

}