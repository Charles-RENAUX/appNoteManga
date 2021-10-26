package jee.web.controller;

import jee.core.dao.MangaDAO;
import jee.core.dao.ReviewDAO;
import jee.core.dao.UserDAO;
import jee.core.entity.Review;
import jee.core.service.MangaService;
import jee.core.service.ReviewService;
import jee.core.service.UserService;
import jee.web.utils.CurrentUser;
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

    @GetMapping("/addReview/{idManga}/fill")
    private String getAddReviewPage(ModelMap map, @PathVariable("idManga") long idManga){
        if(CurrentUser.getInstance().isConnected()) {
            map.addAttribute("manga", mangaService.getManga(idManga));
            map.addAttribute("review", new Review());
            map.addAttribute("connected", CurrentUser.getInstance().isConnected());
            if (CurrentUser.getInstance().isConnected()) {
                map.addAttribute("user", CurrentUser.getInstance().getUser());
            }
            return "addReviewPage";
        }else{
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @RequestMapping(value = "/addReview/{idManga}/form", method = RequestMethod.POST)
    private String submitForm(@ModelAttribute("review") Review review, @PathVariable("idManga") long idManga){
        if (CurrentUser.getInstance().isConnected())
        {
            review.setManga(mangaService.getManga(idManga));
            review.setUser(CurrentUser.getInstance().getUser());
            reviewService.addReview(review);
            return "redirect:http://localhost:8080/reviewPage/" + idManga;
        }else{
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @GetMapping("/deleteReview/{idR}/{idU}")
    private String deleteReview(@PathVariable("idR") long idR, @PathVariable("idU") long idU){
        if(CurrentUser.getInstance().getUser().getId()==idU){
            long idManga = reviewService.getReview(idR).getManga().getId();
            reviewService.deleteReview(idR);
            return "redirect:http://localhost:8080/reviewPage/"+idManga;
        }else{
            return "redirect:http://localhost:8080/welcome";
        }
    }
}
