package richie.belt3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.belt3.models.Student;
import richie.belt3.repositories.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Student getOneStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }
    
    public void createStudent(Student student) {
        studentRepository.save(student);
    }
    
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }
    
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}

