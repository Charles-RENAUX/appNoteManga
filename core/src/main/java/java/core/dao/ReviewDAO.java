package java.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.core.entity.Review;

public interface ReviewDAO extends JpaRepository<Review,Long> {
}
