

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("this change is from b2");
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		//Connecting Mysql Databases
		
		//Loading driver for mysql
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//creating connection with databases;
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","engineer");
			
			//Inserting values
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			
			
			int i=ps.executeUpdate();
			
			if(i>0){
				
				pw.println("You have successfully registered : "+name);
				
				pw.println("Your Email : " +email+ " & password is : " +pass);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
