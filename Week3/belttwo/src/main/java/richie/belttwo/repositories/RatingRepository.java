package richie.belttwo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import richie.belttwo.models.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long>  {
    List<Rating> findAll();
}
