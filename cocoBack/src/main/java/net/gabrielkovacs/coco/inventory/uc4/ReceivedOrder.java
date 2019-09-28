package net.gabrielkovacs.coco.inventory.uc4;

import java.sql.Date;

public class ReceivedOrder{

    private Date deliveryDate;

    public ReceivedOrder() {
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}