package com.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.daoImp.UserBoImp;
import com.blog.model.User;

@WebServlet("/loginUserCheck")

public class LoginUserServlet extends HttpServlet {
    public LoginUserServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserBoImp loginBoImp = new UserBoImp();
		
		User login = loginBoImp.userLogin(email, password);
		String role;
//		if(login.getRole()!= null)
//		{
			role = login.getRole().toLowerCase();
//		}
//		else {
//			role="viewer";
//		}
		
//		System.out.println("role "+role);
		
		int userId = login.getUserId();
//		System.out.println("userId "+userId);
		
		
		PrintWriter out = response.getWriter();
		
		
		if(login !=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			session.setAttribute("role", role);
			session.setAttribute("userId", userId);
			
			 if ("admin".equals(role)) {
                 response.sendRedirect("readAdminPostServlet");
             } else {
                 response.sendRedirect("readviewerBrowsePosts");
             }
		}
		else {
			out.println("Login Fail.......Please Try again");
			
		}
		
		
		
		
		
	
	}

}
