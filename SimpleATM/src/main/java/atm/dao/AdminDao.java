package atm.dao;

import java.util.List;

import atm.bean.Customer;

public interface AdminDao {
  public void addAccount(Customer customer);
  public void deleteAccount(Customer customer);
  public List<Customer> viewAccounts();
  public Customer getCustomer(long id);
  public void updateTempAddress(Customer customer, String address);
  public void updatePermAddress(Customer customer, String address);
  public void updateMobile(Customer customer, long mobile);
  public void updatePin(Customer customer, int pin);
  public List<Customer> viewAccountsByLocation(String permAddress);

}
