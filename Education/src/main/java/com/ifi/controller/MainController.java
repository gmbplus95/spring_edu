package com.ifi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ifi.models.CourseModel;
import com.ifi.models.CourseRepo;
import com.ifi.models.StModel;
import com.ifi.models.StudentRepo;

@Controller
public class MainController {
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	CourseRepo courseRepo;
	@RequestMapping("/")
	//Student
	public String goHome(Model model){
		model.addAttribute("listStudent", studentRepo.findAll());	
		return "index";
		}
	
	@PostMapping(value= "/save_st")
	public ModelAndView saveSt(@RequestParam("studentid") String studentid,
			@RequestParam("studentName") String studentName,
			@RequestParam("studentAge") String studentAge,
			@RequestParam("studentLocation") String studentLocation) {
		ModelAndView mv=new ModelAndView("redirect:/");
		StModel stModel=new StModel();
		if(studentid.isEmpty()) {
			stModel.setStudentName(studentName);
			stModel.setStudentAge(studentAge);
			stModel.setStudentLocation(studentLocation);
		}
		else if(Integer.parseInt(studentid)>0){
			stModel.setStudentid(Integer.parseInt(studentid));
			stModel.setStudentName(studentName);
			stModel.setStudentAge(studentAge);
			stModel.setStudentLocation(studentLocation);
		}
		
		studentRepo.save(stModel);
		return mv;	
	}
	
	@GetMapping(value="/view_st/{studentid}")
	public ModelAndView viewSt(@PathVariable("studentid") int studentid){
		ModelAndView mv=new ModelAndView("View");
		mv.addObject("listStudent",studentRepo.findById(studentid).orElse(null));
		return mv;
	}
	
	@GetMapping(value="/delete_st/{studentid}")
	public ModelAndView deleteSt(@PathVariable("studentid") int studentid){
		ModelAndView mv=new ModelAndView("redirect:/");
		studentRepo.deleteById(studentid);
		return mv;
	}
	
	@GetMapping(value="/edit_st/{studentid}")
	public String editSt(@PathVariable("studentid") int studentid,Model model){
		model.addAttribute("listStudent",studentRepo.findById(studentid).orElse(null));
		return "edit";
	}
	//Course
	@RequestMapping("/course")
	public String goCourse(Model model){
		model.addAttribute("listCourse", courseRepo.findAll());	
		return "index-2";
		}

	@PostMapping(value= "/save_co")
	public ModelAndView saveSt(@RequestParam("courseid") String courseid,
			@RequestParam("coursename") String coursename
			) {
		ModelAndView mv=new ModelAndView("redirect:/course");
		CourseModel courseModel=new CourseModel();
		if(courseid.isEmpty()) {
			courseModel.setCoursename(coursename);
		}
		else if(Integer.parseInt(courseid)>0){
			courseModel.setCourseid(Integer.parseInt(courseid));
			courseModel.setCoursename(coursename);
		}
		
		courseRepo.save(courseModel);
		return mv;	
	}
	
}
	