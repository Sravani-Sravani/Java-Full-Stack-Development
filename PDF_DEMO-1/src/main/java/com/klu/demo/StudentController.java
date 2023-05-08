package com.klu.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

@Controller
public class StudentController {

    private StudentService studentService;
    private PDFService pdfService;

    
    @GetMapping("/index")
    public ModelAndView index()
    {
      ModelAndView mv=new ModelAndView();
      mv.setViewName("index");
      return mv;
    }
    @Autowired
    public StudentController(StudentService studentService, PDFService pdfService) {
        this.studentService = studentService;
        this.pdfService = pdfService;
    }

    @GetMapping("/students/{id}")
    public ModelAndView studentsView(ModelAndView modelAndView ,@PathVariable("id") long id) {
        modelAndView.addObject("students", studentService.getStudents(id));
        modelAndView.setViewName("thymeleaf/students");
        return modelAndView;
    }

    @RequestMapping(value="/download-pdf/{id}",method=RequestMethod.GET)
    public void downloadPDFResource(HttpServletResponse response,@PathVariable("id") long id) {
        try {
            Path file = Paths.get(pdfService.generatePdf(id).getAbsolutePath());
            if (Files.exists(file)) {
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition",
                        "attachment; filename=" + file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        }
    }
}