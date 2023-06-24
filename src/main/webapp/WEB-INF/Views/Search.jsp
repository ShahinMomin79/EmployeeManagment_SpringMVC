<%@page import="com.jspiders.SpringMVC.POJO.EmployeePOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Navbar.jsp"></jsp:include>
    <% String msg=(String)request.getAttribute("msg"); %>
    <%EmployeePOJO emp=(EmployeePOJO)request.getAttribute("emp"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#data{
       border: 2px solid;
}
#data td{
border: 1px solid;}
</style>
</head>
<body>
  <div align="center">
  <form action="./search" method="post">
  <fieldset>
            <legend>Search Employee</legend>
            <table>
            <tr>
            <td>Enter the Id</td>
            <td><input type="text" name="id"></td>
            </tr></table>
  </fieldset>
  <input type="submit" value="Search">
  </form>
  <%if(msg!=null){ %>
  <h3><%=msg %></h3>
  <%} %>
  <% if(emp!=null){%>
  
  <table id="data">
  <thead>
      <tr> 
         <td>Id</td>
         <td>Name</td>
         <td>Email</td>
         <td>Contact</td>
         <td>Designation</td>
         <td>Salary</td> </tr> </thead>
       <tr> <td><%=emp.getId()%></td>
       <td><%=emp.getName()%></td>
       <td><%=emp.getEmail()%></td>
       <td><%=emp.getContact()%></td>
       <td><%=emp.getDesignation()%></td>
       <td><%=emp.getSalary()%></td></tr>
  <%} %>
  </table>
  
  </div>

</body>
</html>