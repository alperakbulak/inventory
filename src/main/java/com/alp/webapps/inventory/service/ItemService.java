package com.alp.webapps.inventory.service;

import com.alp.webapps.inventory.domain.Item;
import com.alp.webapps.inventory.domain.ItemAddForm;

/**
 * Created by Alper AKBULAK
 */

public interface ItemService {
    Item getItemById(long id);

    void addItem(ItemAddForm form);

    Iterable<Item> getItems();

    Item assignItem(String username, long itemId);

    void deleteItemById(long id);
}
