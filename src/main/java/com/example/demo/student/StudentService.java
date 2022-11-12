package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.IllegalTransactionStateException;
import javax.xml.bind.SchemaOutputResolver;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudent(){
                return  studentRepository.findAll();
    }
    public void addNewStudent(Student student) {

        Optional<Student> studentOptional =
  studentRepository.findStudentByEmail(student.getEmail());
            if(studentOptional.isPresent()){
                System.out.println("exception");
            }
            studentRepository.save(student);
        }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            System.out.println("student with id " + studentId + "does not exists!");
        }
        studentRepository.deleteById(studentId);

    }
}
