package atm.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import atm.bean.Customer;
import atm.bean.TransactionRecord;
import atm.dao.TransactionDao;

import static java.lang.System.out;

@Repository
public class CustomerRepository implements TransactionDao {
  private JdbcOperations jdbcOperations;
  private SimpleJdbcInsert insertTransaction;
  // private SimpleJdbcCall procReadTransaction;

  @Autowired
  public CustomerRepository(DataSource dataSource) {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    this.jdbcOperations = jdbcTemplate;
    this.insertTransaction = new SimpleJdbcInsert(dataSource).withTableName("ATM_TRANSACTION");


    jdbcTemplate.setResultsMapCaseInsensitive(true);

    /*
     * this.procReadTransaction=new SimpleJdbcCall(jdbcTemplate)
     * .withProcedureName("GET_TRANSACTION_REPORT") .returningResultSet("transactions", new
     * TransactionRecordMapper());
     */
  }

  private static final class CustomerRowMapper implements RowMapper<Customer> {

    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

      return new Customer(rs.getLong("ACC_NO"), rs.getString("ACC_TYPE"), rs.getString("ACC_NAME"),
          rs.getInt("ACC_PIN"), rs.getString("TEMP_ADDRESS"), rs.getString("PERM_ADDRESS"),
          rs.getDate("JOIN_DATE"), rs.getBigDecimal("BALANCE"), rs.getLong("MOBLIE")


      );
    }

  }

  public Customer findCustomer(long id) {
    // System.out.println(user.getId()+" "+user.getPin());
    String sql = "SELECT * FROM ATM_ACCOUNT WHERE ACC_NO=?";
    /*
     * In JdbcTemplate , queryForInt, queryForLong, queryForObject all such methods expects that
     * executed query will return one and only one row. If you get no rows or more than one row that
     * will result in IncorrectResultSizeDataAccessException =>use query method instead..
     */
   /* List<Customer> cc = jdbcOperations.query(sql, new Object[] {id}, new CustomerRowMapper());
    
    //!=null->exception
    if (cc.size()!=0) {
      out.println("is Not Null!");
      return cc.get(0);
    }
    else {
      out.println("is Null!");
      return null;
    }*/
    

    
    try {
      Customer cc = jdbcOperations.queryForObject(sql, new Object[] {id}, new CustomerRowMapper());
      out.println("OK");
      return cc;
    } catch (DataAccessException e) {
      // TODO Auto-generated catch block
      //e.printStackTrace();
      //out.println("Data excp");
      return null;
    } 
    
    
  }

  public boolean deposit(long id, BigDecimal money) {
    String sql = "UPDATE ATM_ACCOUNT SET BALANCE=BALANCE+? WHERE ACC_NO=?";

    int num = jdbcOperations.update(sql, new Object[] {money, id});
    if (num == 1)
      return true;
    else
      return false;

  }

  public boolean withdraw(long id, BigDecimal money) {
    return deposit(id, money.negate());

  }

  public int moneyTransfer(long givId, long revId, BigDecimal money) {

    Customer rev = findCustomer(revId);
    // make it transaction in the future
    if (rev != null) {
      // System.out.println("givId: "+givId);
      boolean b2 = withdraw(givId, money);

      // System.out.println("revId: "+revId);
      boolean b1 = deposit(revId, money);


      if (b1 && b2)
        return 1;
      else
        return -1;

    } else
      return 0;



  }

  // use millisec instead
  public String addZero(int value) {
    String ss = "0";
    if (value < 10)
      return ss + value;
    else
      return Integer.toString(value);
  }

  public long getTransactionId() {
    LocalDateTime today = LocalDateTime.now();
    StringBuilder sb = new StringBuilder();

    sb.append(today.getYear()).append(addZero(today.getMonthValue()))
        .append(addZero(today.getDayOfMonth())).append(addZero(today.getHour()))
        .append(addZero(today.getMinute())).append(addZero(today.getSecond()));

    return Long.parseLong(sb.toString());
  }

  /*
   * public boolean saveTransaction(Customer user,String type,BigDecimal amount) { String sql=
   * "INSERT INTO ATM_TRANSACTION VALUES (?,?,?,?,?,?)";
   * 
   * 
   * long tId=getTransactionId();
   * 
   * LocalDate today1=LocalDate.now(); Date day=Date.valueOf(today1);
   * 
   * int num=jdbcOperations.update(sql,new Object[]{tId,
   * user.getId(),type,amount,user.getBalance(),day});
   * 
   * if(num==1) return true; else return false;
   * 
   * 
   * }
   */

  public boolean saveTransaction(Customer user, String type, BigDecimal amount) {

    Map<String, Object> parameters = new HashMap<String, Object>(6);

    long tId = getTransactionId();
    LocalDate today1 = LocalDate.now();
    Date day = Date.valueOf(today1);

    parameters.put("TRAN_ID", tId);
    parameters.put("ACC_NO", user.getId());
    parameters.put("PARTICULARS", type);
    parameters.put("AMOUNT", amount);
    parameters.put("BALANCE", user.getBalance());
    parameters.put("TRAN_DATE", day);

    int num = insertTransaction.execute(parameters);

    if (num == 1)
      return true;
    else
      return false;

  }



  public List miniStatement(Customer user) {

    /*
     * SqlParameterSource in=new MapSqlParameterSource() .addValue("I_NO", user.getId());
     * 
     * Map m=new HashMap<String, Object>(1); m=procReadTransaction.execute(in);
     * 
     * return (List)m.get("transactions");
     */

    String sql = "SELECT ACC_NO, TRAN_DATE, PARTICULARS, AMOUNT, BALANCE "
        + "FROM(SELECT * FROM ATM_TRANSACTION " + "WHERE ACC_NO=? " + "ORDER BY TRAN_DATE DESC) "
        + "WHERE ROWNUM<11";

    List<TransactionRecord> reports =
        jdbcOperations.query(sql, new Object[] {user.getId()}, new TransactionRecordMapper());

    return reports;


  }



}
