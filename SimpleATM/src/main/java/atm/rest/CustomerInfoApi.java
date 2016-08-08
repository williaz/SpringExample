package atm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import atm.bean.AtmError;
import atm.bean.Customer;
import atm.bean.TransactionRecord;
import atm.dao.TransactionDao;
import atm.service.AdminService;

@RestController
@RequestMapping("/customers")
public class CustomerInfoApi {
  private TransactionDao transactionDao;
  @Autowired
  private AdminService adminService;
  
  @Autowired
  public CustomerInfoApi(TransactionDao transactionDao) {
    this.transactionDao=transactionDao;
  }
  //http://localhost:8081/SimpleATM/customers/profile/1234567890
  @RequestMapping(value="/profile/{id}",method=RequestMethod.GET, 
                  produces="application/json")
  public @ResponseBody Customer findCustmer(@PathVariable long id){
    
    Customer cc =transactionDao.findCustomer(id);
    if(cc==null) {throw new CustomerNotFoundException(id);}
    return cc;

  }
  //http://localhost:8081/SimpleATM/customers/ministatement/1234567890
  @RequestMapping(value="/ministatement/{id}",method=RequestMethod.GET, 
      produces="application/json")
  public @ResponseBody List<TransactionRecord> getMiniStatement(@PathVariable long id){
    
    Customer cc =transactionDao.findCustomer(id);
    if(cc==null) {throw new CustomerNotFoundException(id);}
    return transactionDao.miniStatement(cc);
  }
  //http://localhost:8081/SimpleATM/customers/location/USA
  @RequestMapping(value="/location/{place}", method=RequestMethod.GET,
      produces="application/xml")
  public @ResponseBody List<Customer> getCustmorByLocation(@PathVariable String place){
    List<Customer> lists=adminService.viewAccountsByLocation(place);
    return lists;
    
  }
  
  
  
  @ExceptionHandler(CustomerNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public AtmError customerNotFound(CustomerNotFoundException e){
    
    long id=e.getCustomerId();
    
    return new AtmError(4,"Customer ["+id+"] not found") ;
    
  }
  
  
  
  

  
}
