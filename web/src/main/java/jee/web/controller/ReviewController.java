package jee.web.controller;

import jee.core.dao.MangaDAO;
import jee.core.dao.ReviewDAO;
import jee.core.dao.UserDAO;
import jee.core.entity.Review;
import jee.core.service.MangaService;
import jee.core.service.ReviewService;
import jee.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@Transactional
public class ReviewController {
    private ReviewService reviewService;
    private MangaService mangaService;
    private UserService userService;

    public ReviewController(final ReviewDAO reviewDAO, final MangaDAO mangaDAO, final UserDAO userDAO) {
        this.reviewService = new ReviewService(reviewDAO);
        this.mangaService = new MangaService(mangaDAO);
        this.userService = new UserService(userDAO, reviewDAO);

    }

    @GetMapping("/addReview/{idManga}/{idUser}/fill")
    private String getAddReviewPage(ModelMap map, @PathVariable("idManga") long idManga, @PathVariable("idUser") long idUser){
        //test user co

        map.addAttribute("manga", mangaService.getManga(idManga));
        map.addAttribute("user", userService.findUser(idUser));
        map.addAttribute("review", new Review());
        return "addReviewPage";
    }

    @RequestMapping(value = "/addReview/{idManga}/{idUser}/form", method = RequestMethod.POST)
    private String submitForm(@ModelAttribute("review") Review review, @PathVariable("idManga") long idManga, @PathVariable("idUser") long idUser){
        //TEST USER CO

        review.setManga(mangaService.getManga(idManga));
        review.setUser(userService.findUser(idUser));
        System.out.println("ADDING REVIEW FOR ID: "+idUser+" with user found: "+review.getUser().getPseudo());
        reviewService.addReview(review);
        return "redirect:http://localhost:8080/reviewPage/"+idManga;
    }
}
