package com.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.daoImp.UserBoImp;
import com.blog.model.User;
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
       
    public RegisterUserServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		User log = new User(name,email,password,role);
		
		UserBoImp loginUserBoImp = new UserBoImp();
		PrintWriter out = response.getWriter();
		
		int i = loginUserBoImp.userRegister(log);
		
		if(i == 1)
		{
			response.sendRedirect("login_user.jsp");
		}
		else {
			out.println("Not Registered... Please Try again");
			
		}
		
		
		
		
	
	}



}
