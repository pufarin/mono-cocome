package net.gabrielkovacs.coco.inventory;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangePriceController {

    private StockItemRepository stockItemRepository;
    private StockItemResponse stockItemResponse;

    public ChangePriceController(StockItemRepository stockItemRepository, StockItemResponse stockItemResponse) {
        this.stockItemRepository = stockItemRepository;
        this.stockItemResponse = stockItemResponse;
    }

    @GetMapping("stockitem/store/{storeId}")
    public List<StockItem> getStockItemByStoreId(@PathVariable long storeId){
        return stockItemRepository.findAllByStoreId(storeId);
    }

    @GetMapping("stockitem")
    public StockItemResponse getAllStockItems(){
        List<StockItem> stockItems = stockItemRepository.findAll();
        stockItemResponse.setStockItem(stockItems);
        return stockItemResponse; 
    }

}