<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="frmAdd" method="post" action="connectInsert.jsp">
		<table width="374" border="1">
			<tr>
				<th width="140">
					<div align="left">EmployeeID</div>
				</th>
				<td width="272"><input type="text" name="EmployeeID"
					size="20"></td>
			</tr>
			<tr>
				<th width="140">
					<div align="left">LastName</div>
				</th>
				<td><input type="text" name="LastName" size="20"></td>
			</tr>
			<tr>
				<th width="140">
					<div align="left">FirstName</div>
				</th>
				<td><input type="text" name="FirstName" size="20"></td>
			</tr>
			<tr>
				<th width="140">
					<div align="left">Title</div>
				</th>
				<td><input type="text" name="Title" size="20"></td>
			</tr>
			<tr>
				<th width="140">
					<div align="left">Address</div>
				</th>
				<td><input type="text" name="Address" size="20"></td>
			</tr>
			<tr>
				<th width="140">
					<div align="left">City</div>
				</th>
				<td><input type="text" name="City" size="20"></td>
			</tr>
		</table>
		<input type="submit" value="Save">
	</form>
</body>
</html>