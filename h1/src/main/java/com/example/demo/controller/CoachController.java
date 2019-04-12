package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Coach;
import com.example.demo.domain.Course;
import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CoachService;
import com.example.demo.service.CourseService;
import com.example.demo.service.CustomerService;
import com.example.demo.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Set;

@Controller
public class CoachController {

    @Autowired
    CoachService coachService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/coach_signup", method = RequestMethod.POST)
    @ResponseBody
    public String signUp(@RequestParam("username") String username, @RequestParam("password") String password,
                         @RequestParam("mobileNum") String mobileNum, @RequestParam("address") String address) {
        System.out.println("---------------------------------------------->");
        Coach c = new Coach();
        c.setAddress(address);
        c.setMobileNum(mobileNum);
        c.setPassword(password);
        c.setUsername(username);
        coachService.signUp(c);
        return JSON.toJSONString(c);
    }

    @RequestMapping(value = "/coach_signin", method = RequestMethod.POST)
    @ResponseBody
    public String singIn(@RequestParam String username, @RequestParam String password) {
        Coach c = coachService.login(username, password);
        return JSON.toJSONString(c);
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() throws InterruptedException {


        for(int i=8;i<13;i++) {

            Coach coach = coachService.getById(i);
            Course course = new Course("course-----------"+i+5);
            course.setCoach(coach);
            //Coach coach = new Coach("xifoo------"+i, "123456", "18801292026", "BJTU");

        /*Customer customer = new Customer("cifoo","123456","18801292026","BJTU");
        Customer customer1 = new Customer("cifoo1","123456","18801292026","BJTU");

        Course course = new Course("course---1");
        course.getCustomers().add(customer);
        course.getCustomers().add(customer1);

        coach.getCourses().add(course);
        course.setCoach(coach);

        courseService.save(course);
        Thread.sleep(3000);*/
            //coachService.save(coach);
            courseService.save(course);
        }

        return JSON.toJSONString(12342567);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public String find(){
        Course course = courseService.findByName("course---1");

        String s1 = JSON.toJSONString(course.getCoach());
        String s2 = JSON.toJSONString(course.getCustomers());
        return s1+"</br>"+s2;
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public String listcourse(ModelMap modelMap,
                                   @RequestParam(value = "page", defaultValue = "1") Integer pageNo,
                                   @RequestParam(value = "size", defaultValue = "4") Integer size){
        Page<Course> courses = this.courseService.getCourses(pageNo, size);
        modelMap.addAttribute("courses",courses);
        System.out.println(Arrays.asList(courses));
        return JSON.toJSONString(courses);
    }

}