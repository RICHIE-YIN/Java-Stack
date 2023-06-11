package richie.belttwo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.belttwo.models.Rating;
import richie.belttwo.repositories.RatingRepository;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public void createRating(Rating rating) {
        ratingRepository.save(rating);
    }

}
