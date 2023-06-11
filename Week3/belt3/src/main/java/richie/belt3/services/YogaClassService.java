package richie.belt3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.belt3.models.YogaClass;
import richie.belt3.models.User;
import richie.belt3.repositories.YogaClassRepository;
import richie.belt3.repositories.UserRepository;

@Service
public class YogaClassService {

    @Autowired
    private YogaClassRepository yogaClassRepository;

    public boolean nameExists(String name) {
        YogaClass yogaClass = yogaClassRepository.findByName(name);
        return yogaClass != null;
    }

    public YogaClass createYogaClass(YogaClass yogaclass) {
        return yogaClassRepository.save(yogaclass);
    }
    

    public List<YogaClass> getAllYogaClass() {
        return (List<YogaClass>) yogaClassRepository.findAll();
    }

    public YogaClass getOneYogaClass(Long id) {
        Optional<YogaClass> optionalYogaClass = yogaClassRepository.findById(id);
        return optionalYogaClass.orElse(null);
    }

    public List<YogaClass> findByUserId(Long userId) {
        return yogaClassRepository.findByUserId(userId);
    }

    public void deleteYogaClassById(Long id) {
        yogaClassRepository.deleteById(id);
    }

    public void updateYogaClass(YogaClass yogaclass) {
        yogaClassRepository.save(yogaclass);
    }
}

