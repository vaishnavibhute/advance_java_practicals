<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
 <% 
 	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String url="jdbc:mysql://localhost:3306/task?user=root&password=root";
	String query="INSERT INTO STUD_DATA VALUES(?,?,?)";
	
	
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection conn = DriverManager.getConnection(url);
	PreparedStatement preparedStatement=conn.prepareStatement(query);
	preparedStatement.setString(1, id);
	preparedStatement.setString(2, name);
	preparedStatement.setString(3, email);
		
	int result=preparedStatement.executeUpdate();
	if(result==1){
		out.println("<h2>Record Inserted Successfully</h2>");
	}
	else{
		out.println("<h2>Record Not Inserted Successfully</h2>");
	}
	conn.close();
	%>
	
	
</body>
</html>