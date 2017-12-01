<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		/* String CusID = "";
		if (request.getParameter("CustomerID") != null) {
			CusID = request.getParameter("CustomerID");
		} */
		Connection connect = null;
		Statement s = null;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jsp;user=sa;password=quyenhatuan1234");
			s = connect.createStatement();
			String strEmployeeID = request.getParameter("EmployeeID");
			String strLastName = request.getParameter("LastName");
			String strFirstName = request.getParameter("FirstName");
			String strTitle = request.getParameter("Title");
			String strAddress = request.getParameter("Address");
			String strCity = request.getParameter("City");
			
			String sql = "INSERT INTO Employees"+
					"(EmployeeID, LastName, FirstName, Title, Address, City)"+
					" VALUES ('"+ strEmployeeID +"','"+ strLastName +"','"+ strFirstName +"','"+strTitle +"','"+ strAddress +"','"+ strCity + "')";
			s.execute(sql);
			out.println("Record Inserted Successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			if (s != null) {
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	%>
</body>
</html>