package jee.web.controller;

import jee.core.dao.ReviewDAO;
import jee.core.entity.Manga;
import jee.core.entity.Review;
import jee.core.service.ReviewService;
import jee.web.utils.CurrentUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import jee.core.dao.MangaDAO;
import jee.core.service.MangaService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
public class MangaController {

    private MangaService mangaService;
    private ReviewService reviewService;

    public MangaController(final MangaDAO mangaDAO, final ReviewDAO reviewDAO) {
        this.mangaService = new MangaService(mangaDAO);
        this.reviewService = new ReviewService(reviewDAO);
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

    @GetMapping("/manga/delete/{id}")
    private String deleteManga(ModelMap map, @PathVariable("id") long id){
        if(CurrentUser.getInstance().getUser().getAdmin()){
            mangaService.delete(mangaService.getManga(id));
            return "redirect:http://localhost:8080/userPage/fill";
        }else{
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @GetMapping("/manga/update/{id}/fill")
    private String updateManga(ModelMap map, @PathVariable("id") long id){
        if(CurrentUser.getInstance().getUser().getAdmin()){
            map.addAttribute("manga" ,mangaService.getManga(id));
            map.addAttribute("connected", CurrentUser.getInstance().isConnected());
            map.addAttribute("user",CurrentUser.getInstance().getUser());
            return "addMangaPage";
        }else{
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @PostMapping("/manga/update/{id}/form")
    private String sendUpdateManga(ModelMap map, @PathVariable("id") long id, @ModelAttribute("manga") Manga manga){
        if(CurrentUser.getInstance().getUser().getAdmin()){
            manga.setId(id);
            manga.setNote();
            manga.setCreationDate(mangaService.getManga(id).getCreationDate());
            for(Review review : reviewService.getAllReviewForManga(id)) {
                reviewService.deleteReview(review);
            }
            mangaService.addManga(manga);
            return "redirect:http://localhost:8080/reviewPage/"+id;
        }else{
            return "redirect:http://localhost:8080/welcome";
        }
    }

}
