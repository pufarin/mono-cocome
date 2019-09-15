package net.gabrielkovacs.coco.inventory.uc3;

import org.springframework.data.jpa.repository.JpaRepository;

import net.gabrielkovacs.coco.inventory.ProductOrder;

interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {


}