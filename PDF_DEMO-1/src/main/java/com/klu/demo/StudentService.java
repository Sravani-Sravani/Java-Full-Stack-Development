package com.klu.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class StudentService {
	@Autowired
	  StudentRepository sturepository;
	 public List<Student> getStudents(Long id)
	  {
	    return (List<Student>)sturepository.findAll();
	  }
}