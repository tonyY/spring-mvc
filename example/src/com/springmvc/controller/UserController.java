package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;
	private final Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = { "/User/{id}", "/user/{id}.json" }, method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("getUser-------------->id=" + id);
		User u = userService.getUser(1);
		return u;
	}

	/**
	 * ÊÂÎñ»Ø¹ö
	 * 
	 * @return
	 */
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public @ResponseBody String insertUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("tempUser") User tempUse) {
		try {
			userService.insertUser(tempUse);
			return "success";
		} catch (Exception e) {
			logger.error(e);
		}
		return "error|Exception ";
	}

}
