package org.virtue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.virtue.pojo.ServiceUser;
@Repository
public interface UserRepository extends JpaRepository<ServiceUser, Long> {
}
