package com.blog.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blog.dao.LoginUserBo;
import com.blog.model.User;

public class UserBoImp implements LoginUserBo{

	private static Connection connection=null;
	private static PreparedStatement prepareStatement;
	private static Statement statement;
	private static ResultSet res;
	
	private final static String IN_REGISTER_QUERY = "INSERT INTO `user` (`name`,`email`,`password`,`role`) VALUES(?,?,?,?)";
	
	private final static  String GET_LOGIN_QUERY = "SELECT * FROM `user` where `email`=? and `password`=?";
	
	private final static String GET_ALL_ADMIN_QUERY = "SELECT * FROM  `user` WHERE `role`='admin'";
	
	
	public static final UserBoImp objUserBoImp() {
		return new UserBoImp();
	}
	
	
	public UserBoImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogapp","root","root");			
			
		} catch (ClassNotFoundException |SQLException e1) {
			e1.printStackTrace();
		} 
		
	}

	
	@Override
	public User userLogin(String email, String password) {
		User log =null;
		
		
	try {
				prepareStatement=connection.prepareStatement(GET_LOGIN_QUERY);
				prepareStatement.setString(1, email);
				prepareStatement.setString(2, password);
				
				ResultSet res = prepareStatement.executeQuery();
				
				if(res.next())
				{
					int userId = res.getInt("id");
					String name = res.getString("name");
					email = res.getString("email");
					password = res.getString("password");
					String role = res.getString("role");
//					System.out.println(userId+" "+name+" "+email+" "+password+" "+role);
					log=new User(userId,name,email,password,role);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return log;
			
	}
	
	public int userRegister(User log) {
		
		try {
			prepareStatement = connection.prepareStatement(IN_REGISTER_QUERY);
			prepareStatement.setString(1, log.getName());
			prepareStatement.setString(2, log.getEmail());
			prepareStatement.setString(3, log.getPassword());
			prepareStatement.setString(4, log.getRole());
			
			int i = prepareStatement.executeUpdate();
			return i;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
					}
		return 0;
		
		
	}
		@Override
		public List<User> getAllAdmins() {
			
			User user=null;
			ArrayList<User> list = new ArrayList<User>();
			
			try {
				statement = connection.createStatement();
				res= statement.executeQuery(GET_ALL_ADMIN_QUERY);
				
				while(res.next())
				{
					int userId = res.getInt("id");
					String name = res.getString("name");
					String email = res.getString("email");
					String password = res.getString("password");
					String role = res.getString("role");
					user=new User(userId,name,email,password,role);
//					Date date = res.getDate("date");
					
					list.add(user);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		
	}
	
	

}
