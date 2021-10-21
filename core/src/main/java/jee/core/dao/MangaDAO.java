package jee.core.dao;

import jee.core.entity.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaDAO extends JpaRepository<Manga, Long> {
}
