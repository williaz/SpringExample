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
	private CustomerRepository customerRepository;
	
	@Autowired
	public userLoginController(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUserLogin() {
		return "userLogin";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String validCustomer(Customer user) {
		Customer cc=customerRepository.findCustomer(user.getId());
		if(cc!=null) {
			if(cc.getPin()==user.getPin())
			{
				return "redirect:/userHome";
			}
			else
				return "userLogin";
		}
		else
			return "userLogin";
		
	}

}
