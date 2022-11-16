package peaksoft.model.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.model.Student;
import peaksoft.model.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/savepage")
    public String createStudent(Model model) {
        model.addAttribute("student", new Student());
        return "create_student";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student/getAll";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "get_all";
    }

    public void method() {
        System.out.println("Hello everyBody!");
    }

    @RequestMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") Long studentId) {
        Student student = studentService.getById(studentId);
        System.out.println(student);
        studentService.removeStudent(student);
        return "redirect:/student/getAll";
    }

    @GetMapping("/update")
    public String updateStudent(@RequestParam("studentId") Long studentId, Model model) {
        model.addAttribute("student", studentService.getById(studentId));
        return "update_student";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("student") Student student) {
        studentService.update(student);
        return "redirect:/student/getAll";
    }
}
