package com.malei.spring.boot.Controller;

import com.malei.spring.boot.model.Faculty;
import com.malei.spring.boot.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView showStartPage() throws Exception {
        ModelAndView modelAndView =  new ModelAndView("index","categories",new Object());
        Faculty faculty = new Faculty();
        faculty.setName("name");
        facultyService.addFaculty(faculty);
        System.out.println(facultyService.getByName("name"));

        return modelAndView ;
    }


}
