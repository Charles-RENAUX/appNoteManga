package jee.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jee.core.entity.Collection;

public interface CollectionDAO extends JpaRepository<Collection,Long> {
}
