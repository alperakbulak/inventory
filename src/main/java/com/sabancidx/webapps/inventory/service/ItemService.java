package com.sabancidx.webapps.inventory.service;

import com.sabancidx.webapps.inventory.domain.ItemAddForm;
import com.sabancidx.webapps.inventory.domain.Item;

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
