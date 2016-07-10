package atm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adminHome")
public class AdminHomeController {

	@RequestMapping(method=RequestMethod.GET)
	public String getAdimHome() {
		return "adminHome";
	}
}
