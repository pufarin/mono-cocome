package net.gabrielkovacs.coco.inventory;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StockItemResponse {

    private List<StockItem> stockItem;

    public List<StockItem> getStockItem() {
        return this.stockItem;
    }

	public void setStockItem(List<StockItem> stockItem) {
        this.stockItem = stockItem;
    }
 


}