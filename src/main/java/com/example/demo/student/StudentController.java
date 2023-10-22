package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepository.save(student);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable (required = true) String id) throws Exception {
        Optional<Student> s = studentRepository.findById(Integer.parseInt(id));
        if(s.isPresent()){
            studentRepository.delete(s.get());
        }
        else{
            throw new Exception("The Student doesn't exist");
        }

    }
    @GetMapping("/all")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    @GetMapping(value = "/count")
    public long countStudent() {
        return studentRepository.count();
    }
    @GetMapping(value = "/byYear")
    public Collection<?> findByYear() {
        return studentRepository.findNbrStudentByYear();
    }
}
