package net.gabrielkovacs.coco.inventory.uc6;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryReportController {

    private DeliveryReportService deliveryReportService;

    public DeliveryReportController(DeliveryReportService deliveryReportService){
        this.deliveryReportService = deliveryReportService;
    }

    @GetMapping("trading-enterprise/{id}/delivery-report")
    public List<DeliveryReport> generateDeliveryReportById(@PathVariable long id){
        return deliveryReportService.generateReport(id);
    }

/*
    @GetMapping("trading-enterprise/{id}/delivery-report")
    public String generateDeliveryReportById(@PathVariable long id){
        return "ffaaaaaaaa";
    }

 */
}
