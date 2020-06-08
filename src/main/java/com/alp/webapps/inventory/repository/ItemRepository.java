package com.alp.webapps.inventory.repository;

import com.alp.webapps.inventory.domain.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Alper AKBULAK
 */


public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findByInventoryCode(String inventoryCode);
}
