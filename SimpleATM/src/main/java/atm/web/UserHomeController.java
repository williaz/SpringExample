package atm.web;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import atm.bean.Customer;
import atm.dao.CustomerRepository;

@Controller
@RequestMapping("/userHome")
@SessionAttributes("customer")

public class UserHomeController {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public UserHomeController(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUserHome() {
		
		
		return "userHome";
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.GET)
	public String makeDeposit(@RequestParam(value="deposit", defaultValue="0") BigDecimal amount,
								@ModelAttribute("customer") Customer cc) {
		long id=cc.getId();
		if (customerRepository.deposit(id, amount))
		{
	
			BigDecimal balance=cc.getBalance().add(amount);
			cc.setBalance(balance);
			
			customerRepository.saveTransaction(cc, "deposit", amount);
			
			String info="Operation Successfully!";
			//model.addFlashAttribute("message", info);

		}
		else
		{
			String info="Operation Unsuccessfully!";
			//model.addFlashAttribute("message", info);

		}
		
		
		return "redirect:/userHome";
	}
	
	
	@RequestMapping(value="/withdraw", method=RequestMethod.GET)
	public String makeWithdraw(@RequestParam(value="withdraw", defaultValue="0") BigDecimal amount,
								@ModelAttribute("customer") Customer cc) {
		long id=cc.getId();
		if (customerRepository.withdraw(id, amount))
		{

			BigDecimal balance=cc.getBalance().subtract(amount);
			cc.setBalance(balance);
			
			customerRepository.saveTransaction(cc, "withdraw", amount);
			
			String info="Operation Successfully!";
			//model.addFlashAttribute("message", info);

		}
		else
		{
			String info="Operation Unsuccessfully!";
			//model.addFlashAttribute("message", info);
 
		}
		
		
		return "redirect:/userHome";
	}
	
	
	@RequestMapping(value="/transfer", method=RequestMethod.GET)
	public String makeTransfer(@RequestParam(value="tid") long tid,
								@RequestParam(value="amount", defaultValue="0") BigDecimal amount,
								@ModelAttribute("customer") Customer cc) {

		int flag=customerRepository.moneyTransfer(cc.getId(), tid, amount);
		if(1==flag)
			{
				
				BigDecimal balance=cc.getBalance().subtract(amount);
				cc.setBalance(balance);
				
				customerRepository.saveTransaction(cc, "transfer", amount);
				
				String info="Operation Successfully!";
			}
		else if(-1==flag)
			{
				String info="Operation Unsuccessfully During Transferring!";
				//model.addFlashAttribute("message", info);

			}

			
		
		else if(0==flag)
		{
			String info="The Account to Transfer Dose Not Exist!";
			//model.addFlashAttribute("message", info);

		}
	
		
		
		
		return "redirect:/userHome";
	}
	
	
	
	
	
	

}
