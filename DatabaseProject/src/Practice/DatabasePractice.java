package Practice;

import java.sql.*;

public class DatabasePractice {

	public static void main(String[] args) {
		// team member comment 1
		// team member comment 2
		
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stat =  null;
		ResultSet rs= null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("problem in loading the driver");
			ex.printStackTrace();
		}
		
		try {
			String dbName = "Employee.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL);
			stat = conn.createStatement();
			
			
			String query = "Insert into emp (Ename,salary) values ('ABC',95000)";
//			stat.executeUpdate(query);
//			
			
			
			query = "Update emp set salary = 120000 where Ename = 'ABC'";
			stat.executeUpdate(query);
			
			query = "Delete from emp where EName = 'Kim'";
			stat.executeUpdate(query);
			
			rs = stat.executeQuery("Select * from emp");
			
			int id;
			String name;
			double sal;
			
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println("ID " + id +", name " + name + ",  salary: " +  sal);
			}
		}
		catch(SQLException ex) {
			System.out.println("problem with database");
		}
		finally {
			try {
				if(conn!=null) {
					rs.close();
					stat.close();
					conn.close();
				}
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		
		

	}
	
	public static void teamMemberFunc() {
		
	}

}
