package atm.rest;

public class CustomerNotFoundException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = -7715985787665871610L;
  private long customerId;

  public CustomerNotFoundException(long customerId) {
    super();
    this.customerId = customerId;
  }

  public long getCustomerId() {
    return customerId;
  }


  
  
}
