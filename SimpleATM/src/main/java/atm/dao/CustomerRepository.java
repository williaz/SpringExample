package atm.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import atm.bean.Customer;
import atm.dao.TransactionDao;

@Repository
public class CustomerRepository implements TransactionDao {
	private JdbcOperations jdbcOperations;

	@Autowired
	public CustomerRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations=jdbcOperations;
	}
	
	private static final class CustomerRowMapper implements RowMapper<Customer> {

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

			return new Customer(
					rs.getLong("ACC_NO"),
					rs.getString("ACC_TYPE"),
					rs.getString("ACC_NAME"),
					rs.getInt("ACC_PIN"),
					rs.getString("TEMP_ADDRESS"),
					rs.getString("PERM_ADDRESS"),
					rs.getDate("JOIN_DATE"),
					rs.getBigDecimal("BALANCE"),
					rs.getLong("MOBLIE")
					
					
					);
		}

	}
	
	public Customer findCustomer(long id) {
		//System.out.println(user.getId()+" "+user.getPin());
		String sql="SELECT * FROM ATM_ACCOUNT WHERE ACC_NO=?";
		Customer cc=jdbcOperations.queryForObject(sql, new Object[] {id}, new CustomerRowMapper());
		
		return cc;
	}

	public boolean deposit(long id, BigDecimal money) {
		String sql="UPDATE ATM_ACCOUNT SET BALANCE=BALANCE+? WHERE ACC_NO=?";
		
		int num=jdbcOperations.update(sql,new Object[]{money,id});
		if(num==1)
			return true;
		else
			return false;
			
	}

	public boolean withdraw(long id, BigDecimal money) {
		return deposit(id,money.negate());
		
	}

	public boolean moneyTransfer(long givId, long revId,BigDecimal money) {
		
		//Customer rev=findCustomer(revId);
		//make it transaction in the future
		
			System.out.println("revId: "+revId);
			boolean b1=deposit(revId,money);
			System.out.println("givId: "+givId);
			boolean b2=withdraw(givId,money);
			
			if(b1&&b2)
				return true;
			else
				return false;
			
		
		
		
	}
	
	public String addZero(int value) {
		String ss="0";
		if(value<10)
			return ss+value;
		else
			return Integer.toString(value);
	}
	
	public long getTransactionId() {
		LocalDateTime today=LocalDateTime.now();
		StringBuilder sb=new StringBuilder();

		 sb.append(today.getYear()).
			append(addZero(today.getMonthValue())).
			append(addZero(today.getDayOfMonth())).
			append(addZero(today.getHour())).
		    append(addZero(today.getMinute())).
		    append(addZero(today.getSecond()));
		
		return Long.parseLong(sb.toString());
	}

	public boolean saveTransaction(Customer user,String type,BigDecimal amount) {
		String sql="INSERT INTO ATM_TRANSACTION VALUES (?,?,?,?,?,?)";
		
		
		long tId=getTransactionId();
		
		LocalDate today1=LocalDate.now();
		Date day=Date.valueOf(today1);
		
		int num=jdbcOperations.update(sql,new Object[]{tId, user.getId(),type,amount,user.getBalance(),day});
		
		if(num==1)
			return true;
		else
			return false;
	
		
	}

	public void miniStatement(Customer user) {
		// TODO Auto-generated method stub
		
	}



}
