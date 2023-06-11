package richie.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.studentroster.models.Dorm;
import richie.studentroster.repositories.DormRepository;

@Service
public class DormService {
    
    @Autowired DormRepository dormRepository;

    public void createDorm(Dorm dorm) {
        dormRepository.save(dorm);
    }

    public List<Dorm> getAllDorms() {
        return dormRepository.findAll();
    }

    public Dorm getOneDorm(Long id) {
        Optional<Dorm> optionalDorm = dormRepository.findById(id);
        return optionalDorm.orElse(null);
    }
}
