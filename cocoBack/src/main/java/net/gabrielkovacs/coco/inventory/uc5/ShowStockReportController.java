package net.gabrielkovacs.coco.inventory.uc5;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.gabrielkovacs.coco.inventory.StockItemRepository;



@RestController
class ShowStockReportController {
    
    private StockItemRepository stockItemRepository;

    
    public ShowStockReportController(StockItemRepository stockItemReportRepository){
        this.stockItemRepository = stockItemReportRepository;
    }
    
    @GetMapping("stockitemreport/{storeId}")
    public List<StockItemReport> getStoreItemReport(@PathVariable long storeId){
        return stockItemRepository.getReportDataForStore(storeId); 
    }
}