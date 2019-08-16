package net.gabrielkovacs.coco.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;

interface StockItemReport {

    long getID();
    @JsonProperty("productName")
    String getName();
    int getAmount();
    int getMinStock();
    int getMaxStock(); 

}