package net.gabrielkovacs.coco.inventory.uc5;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface StockItemReport {

    long getID();
    @JsonProperty("productName")
    String getName();
    int getAmount();
    int getMinStock();
    int getMaxStock(); 

}