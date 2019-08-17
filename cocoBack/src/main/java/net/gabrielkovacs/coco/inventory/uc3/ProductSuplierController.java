package net.gabrielkovacs.coco.inventory.uc3;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import net.gabrielkovacs.coco.inventory.Product;

@RestController
class ProductSuplierController {

    private ProductRepository productRepository;

    public ProductSuplierController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("stockitems/store/{storeId}/lowstock")
    public List<LowStockProduct> getAllProductsWithLowStock(@PathVariable long storeId){
        return productRepository.getProductsUnderMinStock(storeId);
    }
}