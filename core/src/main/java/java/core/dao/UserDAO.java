package java.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.core.entity.User;

public interface UserDAO extends JpaRepository<User,Long> {

}
