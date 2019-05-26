package org.virtue.slave.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.virtue.slave.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
