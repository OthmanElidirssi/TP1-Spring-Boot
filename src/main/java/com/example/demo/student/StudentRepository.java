package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("select year(s.dateNaissance) as annee, count(*) as nbr from Student s group by year(s.dateNaissance) order by year(s.dateNaissance)")
    Collection<?> findNbrStudentByYear();
}
