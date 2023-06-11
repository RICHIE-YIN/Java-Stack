package richie.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import richie.studentroster.models.Dorm;

public interface DormRepository extends CrudRepository<Dorm, Long> {
    List<Dorm> findAll();
}
