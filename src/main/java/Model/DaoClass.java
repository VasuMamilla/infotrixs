package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoClass {
	static Connection con=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate","root","sql123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int addemp(DtoClass dt1) {
		PreparedStatement pstmt=null;
		String query="insert into employee values(?,?,?)";
		int count=0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, dt1.getId());
			pstmt.setString(2, dt1.getName());
			pstmt.setDouble(3, dt1.getSal());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	public int updateemp(DtoClass dt1) {
		PreparedStatement pstmt=null;
		String query="update employee set id=?,name=?,sal=?";
		int count=0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, dt1.getId());
			pstmt.setString(2, dt1.getName());
			pstmt.setDouble(3, dt1.getSal());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	public int deleteemp(DtoClass dt1) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		String query="delete from employee where  id=?";
		int count=0;
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, dt1.getId());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	public ArrayList<DtoClass> display() {
		Statement stmt=null;
		ResultSet rs=null;
		String query="select * from employee";
		ArrayList<DtoClass> list= new ArrayList<>();
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				list.add(new DtoClass(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
