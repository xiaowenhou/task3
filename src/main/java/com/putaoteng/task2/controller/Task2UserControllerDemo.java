package com.putaoteng.task2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.putaoteng.task2.dao.StudentDao;
import com.putaoteng.task2.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.putaoteng.task2.model.BasicVo;

@Controller
public class Task2UserControllerDemo {
	@Resource(name = "studentDao")
	private StudentDao studentDao;

	// 查询所有数据,用get方法
	@RequestMapping(value = "/a/student/list", method = RequestMethod.GET)
	public String queryAll(Model model) {
		List<BasicVo> list = new ArrayList<BasicVo>();

		list = studentDao.queryAll();

		model.addAttribute("studentList", list);
		
		System.out.println("中华人民共和国");
		
		return "studentsList";
	}

	// 添加一条数据,用post方法
	@RequestMapping(value = "/a/student/list", method = RequestMethod.POST)
	public String addOne(Model model, @ModelAttribute Student student) {
		long id = studentDao.countTableLength("*") + 1;
		student.setId(id);
		long times = new Date().getTime();
		System.out.println(times);

		student.setCreateAt(times);
		student.setUpdateAt(times);
		model.addAttribute("student", student);

		return "addStudent";
	}

	// 点提交后,增加数据成功,返回成功页面
	@RequestMapping(value = "/a/student/add", method = RequestMethod.POST)
	public String addSuccess(Model model, Student student) {
		studentDao.addData(student);

		model.addAttribute("student", student);

		return "success";
	}

	// 根据ID查询一条数据,用get方法
	@RequestMapping(value = "/a/student/id/{id}", method = RequestMethod.GET)
	public String queryOne(@PathVariable(value = "id") Integer id, Model model) {
		Student student = (Student) studentDao.queryOneById(id);

		List<Student> list = new ArrayList<Student>();
		list.add(student);

		model.addAttribute("studentList", list);

		return "student";
	}

	// 根据姓名查询一組数据,用get方法
	@RequestMapping(value = "/a/student/name/{name}", method = RequestMethod.GET)
	public String queryByName(@PathVariable(value = "name") String name, Model model) {
		List<BasicVo> list = new ArrayList<BasicVo>();

		/*long startTime = System.currentTimeMillis();*/

		list = studentDao.queryListByName(name);

		/*long endTime = System.currentTimeMillis();
		Long time = endTime - startTime;

		Log.loggerCreate(LogLevel.ERROR, "查找一条数据所耗费的时间为:" + time.toString());*/


		model.addAttribute("studentList", list);

		return "student";
	}

	// 删除一条数据,应该用delete方法,但是前端指定delete方法时要用JavaScript,所以,这里暂用非restful风格的接口
	@RequestMapping(value = "/a/student/id/{id}/delete", method = RequestMethod.GET)
	public String deleteOne(@PathVariable(value = "id") Integer id, Model model) {
		studentDao.deleteData(id);

		return "success";
	}

	// 更新一条数据,用post方法
	@RequestMapping(value = "/a/student/id/{id}", method = RequestMethod.POST)
	public String updateOne(@PathVariable(value = "id") Integer id, Model model) {
		Student student = (Student) studentDao.queryOneById(id);

		student.setUpdateAt(new Date().getTime());
		model.addAttribute("student", student);

		return "editStudent";
	}

	// 点击提交,更新执行,返回成功页面
	@RequestMapping(value = "/a/student/id/{id}/update", method = RequestMethod.POST)
	public String updateSuccess(@PathVariable(value = "id") Integer id, Model model, Student student) {
		studentDao.updateData(student);

		return "success";
	}

}
