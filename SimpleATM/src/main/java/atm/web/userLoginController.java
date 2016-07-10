package atm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import atm.bean.Customer;
import atm.dao.CustomerRepository;

@Controller
@RequestMapping("/userLogin")
public class userLoginController {
	private CustomerRepository customerDao;
	
	@Autowired
	public userLoginController(CustomerRepository customerRepository) {
		customerDao=customerRepository;
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUserLogin() {
		return "userLogin";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String validCustomer(Customer user) {
		
		if(customerDao.vaildCustomer(user))
		{
			return "redirect:/userHome";
		}
		else
			return "userLogin";
	}

}
