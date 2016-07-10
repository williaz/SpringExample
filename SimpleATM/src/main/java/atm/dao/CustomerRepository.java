package atm.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public void deposit(Customer user, BigDecimal money) {
		// TODO Auto-generated method stub
		
	}

	public void withdraw(Customer user, BigDecimal money) {
		// TODO Auto-generated method stub
		
	}

	public void moneyTransfer(Customer user, long accountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void saveTransaction(Customer user) {
		// TODO Auto-generated method stub
		
	}

	public void miniStatement(Customer user) {
		// TODO Auto-generated method stub
		
	}



}
