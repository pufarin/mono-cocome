package net.gabrielkovacs.coco.inventory.uc6;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryReportService {

    private DeliveryReportsRepository deliveryReportsRepository;

    public DeliveryReportService(DeliveryReportsRepository deliveryReportsRepository){
        this.deliveryReportsRepository = deliveryReportsRepository;
    }


    public List<DeliveryReport> generateReport(long tradingEnterpriseId){
        List<DeliveryReport> deliveryReport = new ArrayList<DeliveryReport>();

        List<Long> productSuplierIds = deliveryReportsRepository.getAllProductSubliersByTradingEnterpriseId(tradingEnterpriseId);

        for( long suplierId: productSuplierIds ){
            List<Long> nrDaysPerOrder = deliveryReportsRepository.getNrDeliveryDaysPerProductForAProductSupplier(suplierId);
            deliveryReport.add(new DeliveryReport(suplierId,getMeanTime(nrDaysPerOrder)));
        }
        return deliveryReport;
    }



    private double getMeanTime(List<Long> nrDays){
        double mean = nrDays.stream().mapToLong(Long::longValue).average().orElse(Double.NaN);
        return mean;
    }
}

