package jee.core.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import jee.core.dao.MangaDAO;
import jee.core.entity.Manga;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MangaService {

    private MangaDAO mangaDAO;

    public MangaService (final MangaDAO mangaDAO){
        this.mangaDAO = mangaDAO;
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

    public List<Manga> getAllMangas(){
        return mangaDAO.findAll();
    }

    public List<Manga> getNewMangas(){
        List<Manga> all = mangaDAO.findAll();
        if (all.size()<=6){
            return all;
        }else {
            List<Manga> recent = new ArrayList<Manga>();
            for(int i = 0; i<6; i++){
                recent.add(all.get(i));
            }
            for (int i = 6; i<all.size();i++) {
                if(all.get(i).getCreationDate().before(getTheOldestFromTheList(recent).getCreationDate())){
                    recent.remove(getTheOldestFromTheList(recent));
                    recent.add(all.get(i));
                }
            }
            return recent;
        }
    }

    public Manga getTheOldestFromTheList(List<Manga> list){
        Manga max = list.get(0);
        for (Manga manga : list){
            if(manga.getCreationDate().before(max.getCreationDate()) && manga.getId()!=max.getId()){
                max = manga;
            }
        }
        return max;
    }
}
