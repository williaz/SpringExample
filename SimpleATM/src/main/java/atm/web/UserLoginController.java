package atm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import atm.bean.Customer;
import atm.dao.CustomerRepository;

@Controller
@RequestMapping("/userLogin")
public class UserLoginController {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public UserLoginController(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUserLogin() {
		
		return "userLogin";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String validCustomer(Customer user,RedirectAttributes model) {
		Customer cc=customerRepository.findCustomer(user.getId());
		if(cc!=null) {
			if(cc.getPin()==user.getPin())
			{
				model.addFlashAttribute("customer",cc); 
				//Flash attributes are stored in the session and then retrieved into the model, surviving a redirect.
				return "redirect:/userHome";
			}
			else
				return "userLogin";
		}
		else
			return "userLogin";
		
	}

}