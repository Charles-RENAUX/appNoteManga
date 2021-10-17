package java.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.core.entity.Collection;

public interface CollectionDAO extends JpaRepository<Collection,Long> {
}
