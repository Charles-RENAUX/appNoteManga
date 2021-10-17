package java.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.core.service.MangaService;

@Controller
public class MangaController {

    private MangaService mangaService;

    public MangaController(MangaService _mangaService) {
        this.mangaService = _mangaService;
    }

    @GetMapping("/welcome")
    private String getListNewMangas(ModelMap map) {
        map.addAttribute("listNewManga", mangaService.getNewMangas());
        return "newMangaPage";
    }

    @GetMapping("/explore")
    private String getListExplore(ModelMap map) {
        map.addAttribute("listExploreManga", mangaService.getAllMangas());
        return "explorePage";
    }

    @GetMapping("/reviewPage/{id}")
    private String getReviewManga(ModelMap map, @PathVariable("id") long id) {
        map.addAttribute("listExploreManga", mangaService.getManga(id));
        return "reviewMangaPage";
    }

}
