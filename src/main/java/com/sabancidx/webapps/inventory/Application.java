package com.sabancidx.webapps.inventory;

/**
 * Created by Alper AKBULAK
 */

import com.sabancidx.webapps.inventory.domain.Item;
import com.sabancidx.webapps.inventory.domain.User;
import com.sabancidx.webapps.inventory.repository.ItemRepository;
import com.sabancidx.webapps.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Application implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... strings) throws Exception {
        Item item1 = new Item("123S", "Bilgisayar");
        Item item2 = new Item("358G", "Bilgisayar");
        Item item3 =  new Item("158A", "Bilgisayar");
        Item item4 = new Item("935C", "Telefon");

        Set set1 = new HashSet<Item>();
        set1.add(item1);
        set1.add(item3);
        set1.add(item4);

        Set set2 = new HashSet<Item>();
        set2.add(item2);

        User user1 = new User("alper", "Dd123456");
        user1.setName("Alper");
        user1.setLastName("AKBULAK");
        user1.setItems(set1);

        User user2 = new User("yagmur", "Dd123456");
        user2.setName("Yağmur");
        user2.setLastName("AKBULAK");
        user2.setItems(set2);

        item1.setUser(user1);
        item3.setUser(user1);
        item4.setUser(user1);

        item2.setUser(user2);

        userRepository.save(user1);
        userRepository.save(user2);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);
    }
}


