package java.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.core.entity.Manga;

public interface MangaDAO extends JpaRepository<Manga, Long> {
}
