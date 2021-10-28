package jee.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import jee.core.dao.ReviewDAO;
import jee.core.entity.Review;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReviewService {

    private ReviewDAO reviewDAO;

    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);

    public ReviewService (ReviewDAO _reviewDao){
        this.reviewDAO = _reviewDao;
    }

    public void addReview(Review review){
        reviewDAO.save(review);
    }

    public List<Review> getAllReviewForUser(long id){
        List<Review> res =  new ArrayList<Review>();
        for (Review review : reviewDAO.findAll()){
            if (review.getUser().getId()==id){
                res.add(review);
            }
        }
        return res;
    }

    public List<Review> getAllReviewForManga(long id){
        List<Review> res =  new ArrayList<Review>();
        for (Review review : reviewDAO.findAll()){
            if (review.getManga().getId()==id){
                res.add(review);
            }
        }
        return res;
    }

    public void deleteReview(Review review){
        reviewDAO.delete(review);
    }

    public void deleteReview(long id){
        reviewDAO.deleteById(id);
    }


    public Review getReview(long id){
        Review r = reviewDAO.findById(id).get();
        return r;
    }
}
