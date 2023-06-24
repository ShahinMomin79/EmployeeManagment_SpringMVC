<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="Navbar.jsp"/>
<% String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>

</head>
<body>
<div align="center">
<form action="./add" method="post">
           <fieldset>
           <legend>Add Employees</legend>
           <table>
                   <tr>
        <td>Name</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><input type="text" name="email"></td>
    </tr>
    <tr>
        <td>Contact</td>
        <td><input type="text" name="contact"></td>
    </tr>
    <tr>
        <td>Designation</td>
        <td><input type="text" name="designation"></td>
    </tr>
    <tr>
        <td>Salary</td>
        <td><input type="text" name="salary"></td>
    </tr>
           </table>
           </fieldset>
           <input type="submit" value="Add">
           <%if(msg!=null){ %>
           <h3><%=msg %></h3>
           <%} %>
</form>
</div>

</body>
</html>