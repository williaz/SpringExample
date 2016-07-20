package atm.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import atm.bean.Customer;
import atm.bean.TransactionRecord;
import atm.dao.CustomerRepository;
import atm.dao.TransactionDao;

@Controller
@RequestMapping("/userHome")
@SessionAttributes("customer")

public class UserHomeController {
	
	//private CustomerRepository customerRepository;
    private TransactionDao transactionDao;


	@Autowired
	public UserHomeController(TransactionDao transactionDao) {
		//this.customerRepository=customerRepository;
		this.transactionDao=transactionDao ;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUserHome(@ModelAttribute("message") String info) {
		
		
		return "userHome";
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.GET)
	public String makeDeposit(@RequestParam(value="deposit", defaultValue="0") BigDecimal amount,
								@ModelAttribute("customer") Customer cc,
								Model model) {
		
		
		
		//String info;
		long id=cc.getId();
		if (transactionDao.deposit(id, amount))
		{
	
			BigDecimal balance=cc.getBalance().add(amount);
			cc.setBalance(balance);
			
			transactionDao.saveTransaction(cc, "deposit", amount);
			
			String info="Operation Successfully!";
			
			model.addAttribute("message", info);

		}
		else
		{
			String info="Operation Unsuccessfully!";
			model.addAttribute("message", info);

		}
		
	
		
		return "redirect:/userHome";
		
		
		
	}
	
	
	@RequestMapping(value="/withdraw", method=RequestMethod.GET)
	public String makeWithdraw(@RequestParam(value="withdraw", defaultValue="0") BigDecimal amount,
								@ModelAttribute("customer") Customer cc,
								Model model) {
		long id=cc.getId();
		try {
      if (transactionDao.withdraw(id, amount))
      {

      	BigDecimal balance=cc.getBalance().subtract(amount);
      	cc.setBalance(balance);
      	
      	transactionDao.saveTransaction(cc, "withdraw", amount);
      	
      	String info="Operation Successfully!";
      	model.addAttribute("message", info);

      }
      else
      {
      	String info="Operation Unsuccessfully!";
      	model.addAttribute("message", info);
 
      }
    } catch (Exception e) {
      String info="You don't own such money!";
      model.addAttribute("message", info);
    }
		
		
		return "redirect:/userHome";
	}
	
	
	@RequestMapping(value="/transfer", method=RequestMethod.GET)
	public String makeTransfer(@RequestParam(value="tid") long tid,
								@RequestParam(value="amount", defaultValue="0") BigDecimal amount,
								@ModelAttribute("customer") Customer cc,
								Model model) {

		try {
      int flag=transactionDao.moneyTransfer(cc.getId(), tid, amount);
      if(1==flag)
      	{
      		
      		BigDecimal balance=cc.getBalance().subtract(amount);
      		cc.setBalance(balance);
      		
      		transactionDao.saveTransaction(cc, "transfer", amount);
      		
      		String info="Operation Successfully!";
      		model.addAttribute("message", info);
      	}
      else if(-1==flag)
      	{
      		String info="Operation Unsuccessfully During Transferring!";
      		model.addAttribute("message", info);

      	}

      	
      
      else if(0==flag)
      {
      	String info="The Account to Transfer Dose Not Exist!";
      	model.addAttribute("message", info);

      }
    } catch (Exception e) {
      String info="Transfer Unsuccessfully During Transferring!";
      model.addAttribute("message", info);
    }
	
		
		
		
		return "redirect:/userHome";
	}
	
	@RequestMapping(value="/report", method=RequestMethod.GET)
	public String generateMiniStatement(@ModelAttribute("customer") Customer cc,
										RedirectAttributes model) {
	
		List<TransactionRecord> transactions=transactionDao.miniStatement(cc);
		
		/*for(TransactionRecord tr:transactions)
		{
			System.out.println(tr);
		}
		*/
		model.addFlashAttribute("reports", transactions);

		
		return "redirect:/userHome";
	}
	
	
	
	

}
