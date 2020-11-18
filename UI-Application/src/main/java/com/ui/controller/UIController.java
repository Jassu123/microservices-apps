package com.ui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.ui.model.CustomerDto;
import com.ui.model.Login;
import com.ui.model.PlanDTO;
import com.ui.model.RegisterBean;


@Controller
public class UIController {
	//Request URL- allPlans
	private  static  String  ALLPLANS_URL="http://localhost:1414/plan/PlanApi/browsePlans";
	
	//Request URL - register
	private   static  String   REGISTER_URL="http://localhost:1414/cust/CustomerApi/register";
	
	//Request URL - login
	private   static  String  LOGIN_URL="http://localhost:1414/cust/CustomerApi/login";
	
	//Request URL - view profile
	private  static  String  PROFILE_URL="http://localhost:1414/cust/CustomerApi/viewProfile/{phoneNumber}";
	
	@Autowired
	RestTemplate  restTemplate;
	
	@GetMapping("/index")
	public   String   getIndexPage() {
		return  "index";
	}
	
	private List<PlanDTO>  getPlans() {
		ParameterizedTypeReference<List<PlanDTO>>  typeRef=new  ParameterizedTypeReference<List<PlanDTO>>() {};
		ResponseEntity<List<PlanDTO>>  re = restTemplate.exchange(ALLPLANS_URL, HttpMethod.GET, null, typeRef);
		List<PlanDTO>   plansList = re.getBody();
		return  plansList;
	}
	
	
	@GetMapping("/registerPage")
	public   String  getRegisterPage(Model  model) {
		//call  Microservice-PlanDetails
				
		RegisterBean   registerBean=new RegisterBean();
		registerBean.setPlansList(getPlans());
		model.addAttribute("registerBean", registerBean);
		
		return  "register";
		
	}
	
	@PostMapping("/addCustomer")
	public   String   addCustomer(@Valid @ModelAttribute RegisterBean  registerBean, BindingResult  result, Model model) {
		
		if(result.hasErrors()) {
			//call  Microservice-PlanDetails
			registerBean.setPlansList(getPlans());
			model.addAttribute("registerBean", registerBean);
			return   "register";			
		}
		
		//call Microservice-Customer
		boolean flag=restTemplate.postForObject(REGISTER_URL, registerBean, Boolean.class);
		if(flag==true) {
			String message="Customer is successfully registered";
			model.addAttribute("message", message);
			return "index";
		}
		else {
			String message="Another Customer is already registered with this phone number, try again";
			model.addAttribute("message", message);
			return "register";
		}
			
	}
	
	@GetMapping("/loginPage")
	public   String   getLoginPage() {
		return  "login";
	}
	
	
	@PostMapping("/loginCustomer")
	public   String   loginCustomer(@RequestParam  Long phoneNo, @RequestParam String password, Model  model, HttpServletRequest request)
	{
		Login  login=new  Login();
		login.setPhoneNumber(phoneNo);
		login.setPassword(password);
		
		//call Microservice-Customer
		boolean  flag=restTemplate.postForObject(LOGIN_URL, login, Boolean.class);
		
		if(flag==true) {
			HttpSession  session=request.getSession();
			session.setAttribute("phoneNumber", phoneNo);
			return "Home";
		}
		else {
			model.addAttribute("message", "Bad Credentials");
			return  "login";
		}
	
	}
	
	@GetMapping("/profile")
	public  String  customerProfile(Model model, HttpServletRequest request) {
		HttpSession  session=request.getSession();
		Long phoneNo = (Long) session.getAttribute("phoneNumber");
		
		CustomerDto  custDto=restTemplate.getForObject(PROFILE_URL, CustomerDto.class, phoneNo);
		
		model.addAttribute("customer", custDto);
		return  "customerProfile";
		
	}
	@GetMapping("/plans")
	public String browseAllPlans(Model model) {
		ParameterizedTypeReference<List<PlanDTO>> typeRef=new ParameterizedTypeReference<List<PlanDTO>>() {};
		ResponseEntity<List<PlanDTO>>  re=restTemplate.exchange(ALLPLANS_URL, HttpMethod.GET, null, typeRef);
		List<PlanDTO> planDtoList = re.getBody();
		model.addAttribute("planDtoList", planDtoList);
		return  "showPlans";
		
	}

}


