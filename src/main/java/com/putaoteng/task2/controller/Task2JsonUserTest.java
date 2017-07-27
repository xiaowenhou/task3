package com.putaoteng.task2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.putaoteng.task2.dao.UserDao;
import com.putaoteng.task2.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.putaoteng.task2.model.BasicVo;

@Controller
public class Task2JsonUserTest {
	@Resource (name="userDao")
	private UserDao userDao;
	
	@RequestMapping (value="/a/user/list", method=RequestMethod.GET)
	public @ResponseBody List<BasicVo> queryAll(){
		List<BasicVo> list = new ArrayList<BasicVo>();
		
	
		list = userDao.queryAll();
		
		return list;
	}
	
	@RequestMapping (value="/a/user/list", method=RequestMethod.POST)
	public @ResponseBody List<BasicVo> addOne(User user){
		userDao.addData(user);
		
		List<BasicVo> list = new ArrayList<BasicVo>();
		list = userDao.queryAll();
		return list;
	}
	
	@RequestMapping (value="/a/user/id/{id}", method=RequestMethod.GET)
	public @ResponseBody User queryOne(@PathVariable (value="id") Integer id){
		User user = (User)userDao.queryOneById(id);
		
		return user;
	}
	
	@RequestMapping (value="/a/user/id/{id}", method=RequestMethod.PUT)
	public @ResponseBody List<BasicVo> updateOne(@PathVariable (value="id") Integer id, User user){
		userDao.updateData(user);
		
		List<BasicVo> list = new ArrayList<BasicVo>();
		list = userDao.queryAll();
		return list;
	}
	
	@RequestMapping (value="/a/user/id/{id}", method=RequestMethod.DELETE)
	public @ResponseBody List<BasicVo> deleteOne(@PathVariable (value="id") Integer id){
		userDao.deleteData(id);
		
		List<BasicVo> list = new ArrayList<BasicVo>();
		list = userDao.queryAll();
		return list;
	}
}
