package net.gabrielkovacs.coco.inventory.uc3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.gabrielkovacs.coco.inventory.Product;

interface ProductRepository extends JpaRepository<Product, Long>{

    Product getProductById(long id);
    List<Product> findAll();

}