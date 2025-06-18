package task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_class {

	public static void main(String[] args) {
		String db_url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="root";
		
		try {
			Connection connection = DriverManager.getConnection(db_url, username, password);
			
		
			String create_DB="create database jdbc_values";
			String useDB="use jdbc_values";
			String createTable="create table emp_info (empcode int,empname varchar(25),empage int, esalary int)";
			String insert="insert into emp_info values (101,'Jenny',25,10000),(102,'Jacky',30,20000),(103,'Joe',20,40000),(104,'John',40,80000),(105,'Shameer',25,90000)";
			String select="Select * from emp_info";
		
			
			Statement smt = connection.createStatement();
			
			smt.execute(create_DB);  
			smt.execute(useDB);
			smt.execute(createTable);
			smt.executeUpdate(insert); 
			
			ResultSet result = smt.executeQuery(select); 
			
			while(result.next()) {
				System.out.println(result.getInt("empcode")+"||"+result.getString("empname")+"||"+result.getInt("empage")+"||"+result.getInt("esalary"));
			}
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
