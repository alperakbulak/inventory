package com.alp.webapps.inventory.service;

import com.alp.webapps.inventory.domain.Item;
import com.alp.webapps.inventory.domain.ItemAddForm;
import com.alp.webapps.inventory.domain.User;
import com.alp.webapps.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Alper AKBULAK
 */

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    public Item getItemByCode(String code) {
        return itemRepository.findByInventoryCode(code);
    }

    public Item getItemById(long id) {
        return itemRepository.findOne(id);
    }

    @CacheEvict(value = "items", allEntries = true)
    public void addItem(ItemAddForm form) {
        for (int i = 0; i < form.getAmount(); i++) {
            String inventoryCode = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(10);
            Item item = new Item(inventoryCode, form.getItemType());
            itemRepository.save(item);
        }
    }
    @Cacheable(value = "items", cacheManager = "springCM")
    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item assignItem(String username, long itemId) {
        User user = userService.getUserByUsername(username);
        Item item = getItemById(itemId);
        Set<Item> itemList = user.getItems();
        item.setUser(user);
        itemList.add(item);
        user.setItems(itemList);

        return itemRepository.save(item);
    }
    @CacheEvict(value = "items", allEntries = true)
    public void deleteItemById(long id) {
        itemRepository.delete(id);
    }
}
