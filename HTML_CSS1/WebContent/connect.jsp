<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection connect = null;
			Statement s = null;

			try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		connect = DriverManager.getConnection(
				"" + "jdbc:sqlserver://localhost:1433;databaseName=jsp;user=sa;password=quyenhatuan1234");

		s = connect.createStatement();

		String sql = "SELECT * FROM  Employees ORDER BY EmployeeID ASC";

		ResultSet rec = s.executeQuery(sql);
	%>
	<table width="600" border="1" style="float: left;">
		<tr>
			<th width="91">
				<div align="center">EmployeeID</div>
			</th>
			<th width="98">
				<div align="center">LastName</div>
			</th>
			<th width="198">
				<div align="center">FirstName</div>
			</th>
			<th width="97">
				<div align="center">Title</div>
			</th>
			<th width="59">
				<div align="center">Address</div>
			</th>
			<th width="71">
				<div align="center">City</div>
			</th>
		</tr>
		<%
			while ((rec != null) && (rec.next())) {
		%>
		<tr>
			<td><div align="center"><%=rec.getString("EmployeeID")%></div></td>
			<td><%=rec.getString("LastName")%></td>
			<td><%=rec.getString("FirstName")%></td>
			<td><div align="center"><%=rec.getString("Title")%></div></td>
			<td align="right"><%=rec.getString("Address")%></td>
			<td align="right"><%=rec.getString("City")%></td>
		</tr>
		<%
			}
		%>
		
		<%-- <%
		s = connect.createStatement();
		
		String strEmployeeID = request.getParameter("EmployeeID");
		String strLastName = request.getParameter("LastName");
		String strFirstName = request.getParameter("FirstName");
		String strTitle = request.getParameter("Title");
		String strAddress = request.getParameter("Address");
		String strCity = request.getParameter("City");
		
		String sqls = "INSERT INTO Employees"+
		"(EmployeeID, LastName, FirstName, Title, Address, City)"+
		" VALUES ('"+ strEmployeeID +"','"+ strLastName +"','"+ strFirstName +"','"+strTitle +"','"+ strAddress +"','"+ strCity + "')";
		s.execute(sql); 
		
		%> --%>
	</table>
	<%
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
	
	<%-- use jstl tag to connect and retrieve data --%>
	<sql:setDataSource var="snapshot"
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost:1433;databaseName=jsp;user=sa;password=quyenhatuan1234" />
		
	<%-- insert --%>
	<sql:update dataSource="${snapshot}" var="result">
		INSERT INTO Employees (EmployeeID, LastName, FirstName, Title, Address, City) VALUES (3, 'phung', 'hang', 'choi', 'hanoi', 'hanoi');
	</sql:update>

	<%-- delete --%>

	<%-- <c:set var="firstName" value="Ha" />
	<sql:update dataSource="${snapshot}" var="count">
	  DELETE FROM Employees WHERE FirstName = ?
	  <sql:param value="${firstName}" />
	</sql:update> --%>
	
	<%-- update --%>
	<c:set var="FirstName" value="Ha" />
	<sql:update dataSource="${snapshot}" var="count">
 	 UPDATE Employees SET LastName = 'QuangTrungKute' where FirstName =?
  	<sql:param value="${FirstName}" />
	</sql:update>

	<%-- query - show--%>
	<sql:query dataSource="${snapshot}" var="result">
			SELECT * from Employees;
	</sql:query>
	<table width="600" border="1"
		style="overflow: auto; margin-left: 620px;">
		<tr>
			<th width="91">
				<div align="center">EmployeeID</div>
			</th>
			<th width="98">
				<div align="center">LastName</div>
			</th>
			<th width="198">
				<div align="center">FirstName</div>
			</th>
			<th width="97">
				<div align="center">Title</div>
			</th>
			<th width="59">
				<div align="center">Address</div>
			</th>
			<th width="71">
				<div align="center">City</div>
			</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.EmployeeID}" /></td>
				<td><c:out value="${row.LastName}" /></td>
				<td><c:out value="${row.FirstName}" /></td>
				<td><c:out value="${row.Title}" /></td>
				<td><c:out value="${row.Address}" /></td>
				<td><c:out value="${row.City}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>