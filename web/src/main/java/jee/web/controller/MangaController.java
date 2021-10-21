package jee.web.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jee.core.dao.MangaDAO;
import jee.core.service.MangaService;

@Controller

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
        return "newMangaPage";
    }

    @GetMapping("/toExplore")
    private String redirectExplore(ModelMap map){
        return "redirect:/explore";
    }

    @GetMapping("/explore")
    private String getListExplore(ModelMap map) {
        map.addAttribute("listExploreManga", mangaService.getAllMangas());
        return "explorePage";
    }

    @GetMapping("/reviewPage/{id}")
    private String getReviewManga(ModelMap map, @PathVariable("id") long id) {
        map.addAttribute("listExploreManga", mangaService.getManga(id));
        return "redirect:reviewMangaPage";
    }

}