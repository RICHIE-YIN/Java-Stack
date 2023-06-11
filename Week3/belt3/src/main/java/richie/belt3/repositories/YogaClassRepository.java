package richie.belt3.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import richie.belt3.models.YogaClass;

public interface YogaClassRepository extends CrudRepository<YogaClass, Long> {
    List<YogaClass> findAll();
    List<YogaClass> findByUserId(Long userId);
    public YogaClass findByName(String name);
}
