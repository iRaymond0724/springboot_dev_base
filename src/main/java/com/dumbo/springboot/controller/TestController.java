package com.dumbo.springboot.controller;

import com.dumbo.springboot.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(value="/test",method = RequestMethod.GET)
    @ResponseBody
    public String Test() {
        System.out.println("Test API");
        return "Test Successful";
    }

    @RequestMapping(value = "/student/allstudent", method = RequestMethod.GET)
    @ResponseBody
    public Student getAllStudents() {
        Student studentRecords = new Student();
        studentRecords.setName("Raymond");
        studentRecords.setAge(26);

        return studentRecords;
    }
}
