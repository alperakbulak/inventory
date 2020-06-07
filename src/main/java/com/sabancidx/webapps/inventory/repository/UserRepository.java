package com.sabancidx.webapps.inventory.repository;

import com.sabancidx.webapps.inventory.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Alper AKBULAK
 */

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
