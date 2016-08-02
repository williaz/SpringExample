package atm.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import atm.bean.Customer;
import atm.service.AdminService;

@Controller
@RequestMapping("/adminHome")
public class AdminHomeController {
    @Autowired
    private AdminService adminService;
  
	@RequestMapping(method=RequestMethod.GET)
	public String getAdimHome(@ModelAttribute("message") String info) {
		return "adminHome";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String AddOrUpdateInfo(String sumbit,
	                              @ModelAttribute Customer cc,
	                              Model model) {
	  
	  if(sumbit.equals("add")) {
	    adminService.addAccount(cc);
	    
	    String info="Added Successfully!";
        model.addAttribute("message", info);

	  }else if (sumbit.equals("update")) {
	    boolean flag=adminService.updateCustomerDetails(cc);
	    if(flag==true) {
	      String info="Updated Successfully!";
	        model.addAttribute("message", info);
	    }
	    else
	    {
	      String info="This customer no exist";
	        model.addAttribute("message", info);
	    }
	    
	    
	  }
	  
	  
	  return "redirect:/adminHome";
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public String viewAll(RedirectAttributes model) {
	  List<Customer> lists= adminService.viewAccounts();
	  model.addFlashAttribute("reports", lists);
	  
	  return  "redirect:/adminHome";
	  
	}
	
	@RequestMapping(value="/location",method=RequestMethod.GET)
    public String searchByLocation(@RequestParam String permAddress,
                                   RedirectAttributes model) {
      List<Customer> lists= adminService.viewAccountsByLocation(permAddress);
      model.addFlashAttribute("reports", lists);
      
      return  "redirect:/adminHome";
      
    }
	
	@RequestMapping(value="/one",method=RequestMethod.GET)
    public String viewOne(@RequestParam Long id,
                          RedirectAttributes model) {
      List<Customer> lists= new ArrayList();
      lists.add(adminService.viewCustomerDetails(id));
      model.addFlashAttribute("reports", lists);
      
      return  "redirect:/adminHome";
      
    }
	
	
	///GK
	@RequestMapping(value="/delete",method=RequestMethod.GET)
    public String delete(@RequestParam Long id, Model model) {
	  boolean flag=adminService.deleteAccount(id);
      if(flag==true) {
        String info="Deleted Successfully!";
          model.addAttribute("message", info);
      }
      else
      {
        String info="This customer no exist";
          model.addAttribute("message", info);
      }
	  
	  return "redirect:/adminHome";
	
	}
}
