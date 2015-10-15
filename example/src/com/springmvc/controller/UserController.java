package com.springmvc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.model.User;
import com.springmvc.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = { "/User/{id}", "/user/{id}.json" }, method = RequestMethod.GET,produces={ "application/xml","application/json"})
	public User getUser(@PathVariable String id, HttpServletRequest request, HttpServletResponse response)
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
			logger.error(e.getMessage());
		}
		return "error|Exception ";
	}
	
	/**
	 * ²âÊÔÀ¹½ØÆ÷
	 * @param locale
	 * @param model
	 * @return
	 */
	 @RequestMapping(value = "/home", method = RequestMethod.GET)
	    public String home(Model model) {
		 	logger.info("Welcome home! ");
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	         
	        model.addAttribute("serverTime", new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	        logger.info("Before returning view page");
	        return "home";
	    }

}
