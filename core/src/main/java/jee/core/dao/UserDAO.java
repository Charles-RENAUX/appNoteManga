package jee.core.dao;

import jee.core.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<Users,Long> {

}
