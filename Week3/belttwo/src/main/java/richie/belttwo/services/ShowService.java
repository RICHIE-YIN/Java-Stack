package richie.belttwo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.belttwo.models.Show;
import richie.belttwo.models.User;
import richie.belttwo.repositories.ShowRepository;
import richie.belttwo.repositories.UserRepository;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public boolean titleExists(String title) {
        Show show = showRepository.findByTitle(title);
        return show != null;
    }

    public Show createShow(Show show) {
        return showRepository.save(show);
    }
    

    public List<Show> getAllShows() {
        return (List<Show>) showRepository.findAll();
    }

    public Show getOneShow(Long id) {
        Optional<Show> optionalShow = showRepository.findById(id);
        return optionalShow.orElse(null);
    }

    public List<Show> findByUserId(Long userId) {
        return showRepository.findByUserId(userId);
    }

    public void deleteShowById(Long id) {
        showRepository.deleteById(id);
    }

    public void updateShow(Show show) {
        showRepository.save(show);
    }

    // public boolean hasUserRatedShow(User user, Show show) {
    //     List<User> raters = show.getRaters();
    //     for (User rater : raters) {
    //         if (rater.getId().equals(user.getId())) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    
}

