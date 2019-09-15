package net.gabrielkovacs.coco.inventory.uc3;

import org.springframework.data.jpa.repository.JpaRepository;

import net.gabrielkovacs.coco.inventory.OrderEntry;

interface OrderEntryRepository extends JpaRepository<OrderEntry, Long> {


}