package com.circus.task.tasklist;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.circus.task.tasklist.dao.DaoTask;
import com.circus.task.tasklist.model.Task;



@Controller
public class TaskListController {
	@Autowired
	DaoTask taskdao;
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		
		List<Task> tasks = taskdao.findAll();
		mav.addObject("tasks",tasks);
		return mav;
	}
	
	@RequestMapping(value="/task/create", method=RequestMethod.POST)
	public ModelAndView submitCreateForm(Task task) {
		taskdao.create(task);
		return new ModelAndView("redirect:/index");
	}
	
	// path variable required to identify which food we're editing
	@RequestMapping("/task/{id}/update")
	public ModelAndView showEditForm(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("edit");
		mav.addObject("task", taskdao.findById(id));
		mav.addObject("task", "Edit Task");
		return mav;
	}
	
	@RequestMapping(value="/task/{id}/update", method=RequestMethod.POST)
	public ModelAndView submitEditForm(Task task, @PathVariable("id") Long id) {
		task.setId(id);
	taskdao.update(task);
		return new ModelAndView("redirect:/task");
	}
	
	@RequestMapping("/task/{id}/delete")
	public ModelAndView delete(@PathVariable("id") Long id) {
		taskdao.delete(id);
		return new ModelAndView("redirect:/task");
	}

}
