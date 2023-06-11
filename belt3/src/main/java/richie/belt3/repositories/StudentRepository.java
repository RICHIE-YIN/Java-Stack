package richie.belt3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import richie.belt3.models.Student;
import richie.belt3.models.YogaClass;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByClasses(YogaClass yogaClass);

    List<Student> findByClassesNotContains(YogaClass yogaClass);
    
}
