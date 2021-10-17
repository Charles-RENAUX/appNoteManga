package java.core.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.core.dao.MangaDAO;
import java.core.entity.Manga;

@Service
@Transactional
public class MangaService {

    private MangaDAO mangaDAO;

    public MangaService (MangaDAO _mangaDao){
        this.mangaDAO = _mangaDao;
    }

    public void delete(Manga manga){
        mangaDAO.delete(manga);
    }

    public void delete(long id){
        mangaDAO.deleteById(id);
    }

    public Manga getManga(long id){
        return mangaDAO.getOne(id);
    }

    public void addManga(Manga manga){
        mangaDAO.save(manga);
    }
}
