package atm.bean;

public class AtmError {
  
  public AtmError(int code, String message) {
    super();
    this.code = code;
    this.message = message;
  }

  private int code;
  private String message;
  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  

}
