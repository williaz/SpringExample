package atm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import atm.bean.Customer;
import atm.dao.CustomerRepository;
import atm.dao.TransactionDao;

@Controller
@RequestMapping("/userLogin")
public class UserLoginController {
	
	//private CustomerRepository customerRepository;
    private TransactionDao transactionDao;
	
	@Autowired
	public UserLoginController(TransactionDao transactionDao) {
		//this.customerRepository=customerRepository;
		this.transactionDao=transactionDao;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUserLogin() {
		
		return "userLogin";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String validCustomer(Customer user,RedirectAttributes model) {
		Customer cc=transactionDao.findCustomer(user.getId());
		if(cc!=null) {

			if(cc.getPin().equals(user.getPin()))
			{
				model.addFlashAttribute("customer",cc); 
				//Flash attributes are stored in the session and then retrieved into the model, surviving a redirect.
				
				return "redirect:/userHome";
			}
			else {
			
				return "userLogin";
			}
		}
		else {
	
		  return "userLogin";
		}
			
		
	}

}