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
		StModel stmodel;
		stmodel=studentRepo.findById(studentid).orElse(null);
		mv.addObject("listStudent",stmodel);
		mv.addObject("listCourse",stmodel.getCoursemodels());
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
	
	@GetMapping(value="/delete_co/{courseid}")
	public ModelAndView deleteCo(@PathVariable("courseid") int courseid){
		ModelAndView mv=new ModelAndView("redirect:/course");
		courseRepo.deleteById(courseid);
		return mv;
	}
	
	@GetMapping(value="/view_co/{courseid}")
	public String viewCo(@PathVariable("courseid") int courseid,Model model){
		CourseModel coursemodel=courseRepo.findById(courseid).orElse(null);
		model.addAttribute("listCourse",coursemodel);
		model.addAttribute("st",coursemodel.getStModels());//lay danh sach student trong course
		model.addAttribute("count",courseRepo.findStudentByCourseId(courseid));
		return "view-2";
	}
	
	@GetMapping(value="/edit_co/{courseid}")
	public String editCo(@PathVariable("courseid") int courseid,Model model){
		model.addAttribute("listCourse",courseRepo.findById(courseid).orElse(null));
		return "edit-2";
	}
	//Course and Student
	
	@GetMapping(value="/view_st/add_co/{studentid}")
	public String addCotoSt(@PathVariable("studentid") int studentid,Model model){
		StModel stmodel;
		stmodel=studentRepo.findById(studentid).orElse(null);
		model.addAttribute("listStudent",stmodel);
		model.addAttribute("listCourse", courseRepo.findAll());
		return "addcotost";
	}
	
	@GetMapping(value="/view_st/saveco")
	public String addCotoSt(@RequestParam("courseid") int courseid,
							   @RequestParam("studentid") int studentid, Model model) {
		StModel stmodel;
		stmodel=studentRepo.findById(studentid).orElse(null);
		CourseModel coursemodels;
		coursemodels=courseRepo.findById(courseid).orElse(null);
		stmodel.getCoursemodels().add(coursemodels);
		studentRepo.save(stmodel);
		return "redirect:/view_st/"+studentid;
	}
	
	@GetMapping(value="/view_st/delete_co/{studentid}")
	public String delCoSt(@PathVariable("studentid") int studentid,Model model){
		StModel stmodel;
		stmodel=studentRepo.findById(studentid).orElse(null);
		model.addAttribute("listStudent",stmodel);
		model.addAttribute("listCourse", stmodel.getCoursemodels());
		return "deleteco";
	}
	
	@GetMapping(value="/view_st/deleteco")
	public String delCoSt(@RequestParam("courseid") int courseid,
							   @RequestParam("studentid") int studentid, Model model) {
		StModel stmodel;
		stmodel=studentRepo.findById(studentid).orElse(null);
		CourseModel coursemodels;
		coursemodels=courseRepo.findById(courseid).orElse(null);
		stmodel.getCoursemodels().remove(coursemodels);
		studentRepo.save(stmodel);
		return "redirect:/view_st/"+studentid;
	}
	
	
}
	