//package com.blog.controller;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//
//import com.blog.daoImp.BlogPostBoImp;
//
//@WebServlet("/imageUploadServlet")
//public class ImageUploadServlet extends HttpServlet {
//    public ImageUploadServlet() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		Part filePart = request.getPart("imageFile");
//		int i=0;
//		if (filePart != null) {
//			
//			  InputStream inputStream = filePart.getInputStream();
//			  
//			  BlogPostBoImp objBImp = BlogPostBoImp.objBlogPostBoImp();
//			  
//			  i = objBImp.filePartUpload(inputStream);
//		
//		}
//		if(i == 1)
//		{
//			response.sendRedirect("imageDisplayServlet?imageId");
//		}
//		else {
//			System.out.println("not uploaded");
//		}
//		
//		
//		
//		
//		
//		
//	}
//
//
//}
