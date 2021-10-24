package jee.web.controller;

import jee.core.dao.ReviewDAO;
import jee.core.entity.Manga;
import jee.core.entity.Review;
import jee.core.service.ReviewService;
import jee.web.utils.CurrentUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jee.core.dao.MangaDAO;
import jee.core.service.MangaService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
public class MangaController {

    private MangaService mangaService;

    public MangaController(final MangaDAO mangaDAO) {
        this.mangaService = new MangaService(mangaDAO);

    }

    @GetMapping("/")
    private String getIndex(ModelMap map){
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    private String getListNewMangas(ModelMap map) {
        map.addAttribute("listNewManga", mangaService.getNewMangas());
        map.addAttribute("connected", CurrentUser.getInstance().isConnected());
        if(CurrentUser.getInstance().isConnected()){
            map.addAttribute("user",CurrentUser.getInstance().getUser());
        }
        return "newMangaPage";
    }

    @GetMapping("/explore")
    private String getListExplore(ModelMap map) {
        map.addAttribute("listExploreManga", mangaService.getAllMangas());
        map.addAttribute("connected", CurrentUser.getInstance().isConnected());
        if(CurrentUser.getInstance().isConnected()){
            map.addAttribute("user",CurrentUser.getInstance().getUser());
        }
        return "explorePage";
    }

    @GetMapping("/reviewPage/{id}")
    private String getReviewManga(ModelMap map, @PathVariable("id") long id) {
        Manga manga = mangaService.getManga(id);
        manga.setNote();
        System.out.println("Dans le controller: "+manga.getNote());
        map.addAttribute("manga", manga);
        map.addAttribute("connected", CurrentUser.getInstance().isConnected());
        if(CurrentUser.getInstance().isConnected()){
            map.addAttribute("user",CurrentUser.getInstance().getUser());
        }
        return "reviewMangaPage";
    }

}
