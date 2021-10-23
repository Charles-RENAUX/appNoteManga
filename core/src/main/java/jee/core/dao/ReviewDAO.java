package jee.core.dao;

import jee.core.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review,Long> {
}
