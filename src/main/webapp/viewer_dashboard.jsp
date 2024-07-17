<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.blog.model.User,java.util.*" %>   
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Admin Dashboard</title>
	    <link rel="stylesheet" href="viewer_dashboard.css">
	</head>
	<body>
		<div class="container">
            <div class="admin">
                
            </div>
            <div class="hero">
            <table style="width:50%">
            <tr>
            <td colspan="3"><h1>Viewer Dashboard</h1></td>
            </tr>
	        <tr>
	            <th>Admin</th>
	            <th>Action</th>
	        </tr>
	         <%
	         	        List<User> admins =(List<User>)request.getAttribute("adminsAll");
	         	        
	                         for (User ad : admins) {
	         %> 
            <tr>
                 <td><%= ad.getName()%></td>
                 
                <td>
                   <a href="viewAdminPosts?adminId=<%= ad.getUserId() %>" target="_blank">View</a>

                </td>
            </tr>
            <% 
                } 
            %> 
	        
	    </table>
	
                
            </div>
        </div>
            
            
            
	    
	</body>
</html>
