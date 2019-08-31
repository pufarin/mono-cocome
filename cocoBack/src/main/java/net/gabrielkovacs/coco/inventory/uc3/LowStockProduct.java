package net.gabrielkovacs.coco.inventory.uc3;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface LowStockProduct {
    @JsonProperty("storeId")
    long getStoreId();
    @JsonProperty("productName")
    String getName();
    int getAmount();
    int getMinStock();
    int getMaxStock();
    

}