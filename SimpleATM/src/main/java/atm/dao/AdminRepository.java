package atm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import atm.bean.Customer;

@Repository("adminDao")
public class AdminRepository implements AdminDao{
  private SessionFactory sessionFactory;

  public AdminRepository(SessionFactory sessionFactory) {
    this.sessionFactory =sessionFactory;
  }
  
  private Session currentSession() {
    return sessionFactory.getCurrentSession();
     
  }
  
  
  @Override
  public void addAccount(Customer customer) {
    
    currentSession().save(customer);

  }

  @Override
  public void deleteAccount(Customer customer) {
    
    currentSession().delete(customer);

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Customer> viewAccounts() {
    return (List<Customer>) currentSession()
            .createCriteria(Customer.class)
            .list();
  }



  @SuppressWarnings("unchecked")
  @Override
  public List<Customer> viewAccountsByLocation(String permAddress) {
    
    return (List<Customer>) currentSession()
           .createCriteria(Customer.class)
           .add(Restrictions.eq("permAddress", permAddress))
           .list();
  }

  @Override
  public Customer getCustomer(long id) {
    return currentSession().get(Customer.class, id);
  }

  @Override
  public void updateTempAddress(Customer customer, String address) {
    
    customer.setTempAddress(address);
    
    currentSession().update(customer);
  }

  @Override
  public void updatePermAddress(Customer customer, String address) {
    customer.setPermAddress(address);
    currentSession().update(customer);
  }

  @Override
  public void updateMobile(Customer customer, long mobile) {
    customer.setMobile(mobile);
    currentSession().update(customer);
  }

  @Override
  public void updatePin(Customer customer, int pin) {
    customer.setPin(pin);
    currentSession().update(customer);
    
  }



}
