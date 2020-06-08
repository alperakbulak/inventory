package com.alp.webapps.inventory.repository;

import com.alp.webapps.inventory.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Alper AKBULAK
 */

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
