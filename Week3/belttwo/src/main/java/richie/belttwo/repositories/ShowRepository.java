package richie.belttwo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import richie.belttwo.models.Show;

public interface ShowRepository extends CrudRepository<Show, Long> {
    List<Show> findAll();
    List<Show> findByUserId(Long userId);
    public Show findByTitle(String title);
}
