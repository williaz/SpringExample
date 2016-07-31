package atm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atm.bean.Customer;
import atm.dao.AdminDao;

@Service
public class AdminService {
  @Autowired
  private AdminDao adminDao;
  
  public boolean addAccount(Customer customer) {
    adminDao.addAccount(customer);
    return true;
  }
  
  public boolean deleteAccount(long id) {
    Customer customer=adminDao.getCustomer(id);
    if(customer!=null) {
      adminDao.deleteAccount(customer);
      return true;
    }else {
      return false;
    }

    
  }
  public List<Customer> viewAccounts(){
    return adminDao.viewAccounts();
    
  }
  public Customer viewCustomerDetails(long id) {
    return adminDao.getCustomer(id);
    
  }
  public boolean updateCustomerDetails(Customer customer) {
    Customer cc=adminDao.getCustomer(customer.getId());
    
    if(cc!=null) {
      if(customer.getPermAddress()!=null) {
        adminDao.updatePermAddress(cc, customer.getPermAddress());
      }
      
      if(customer.getTempAddress()!=null) {
        adminDao.updateTempAddress(cc, customer.getTempAddress());
      }
      
      if(customer.getMobile()!=null) {
        adminDao.updateMobile(cc, customer.getMobile());
      }
      
      if(customer.getPin()!=null) {
        adminDao.updatePin(cc, customer.getPin());
      }

      return true;
      
    }else {
      return false;
    }
    
  }
  public List<Customer> viewAccountsByLocation(String permAddress){
    return adminDao.viewAccountsByLocation(permAddress);
    
  }

}
