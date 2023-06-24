<%@page import="com.jspiders.SpringMVC.POJO.EmployeePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Navbar.jsp"></jsp:include>
    <%List<EmployeePOJO> employees=(List<EmployeePOJO>)request.getAttribute("empList"); %>
    <%EmployeePOJO employee=(EmployeePOJO)request.getAttribute("emp");
      String msg=(String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
<style type="text/css">
#data{
border: 1px solid;
align-content: center;
}
#data td{
border: 1px solid;
align-content: center;
}
</style>
</head>
<body>
<div align="center">
<form action="/update">
    
        <fieldset>
            <legend>Update the record</legend>
            <table>
            <tr>
                <td>Enter the Id</td>
            <td><input type="text" name="id"></td>
            </table>
            </tr>
       </fieldset>
       <input type="submit" value="Update">
   </form>
    <%
     if(employees!=null){
     %>
       <table id="data">
  <thead>
      <tr> 
         <td>Id</td>
         <td>Name</td>
         <td>Email</td>
         <td>Contact</td>
         <td>Designation</td>
         <td>Salary</td> </tr> </thead>
         <%for(EmployeePOJO pojo: employees){%>
       <tr> <td><%=pojo.getId()%></td>
       <td><%=pojo.getName()%></td>
       <td><%=pojo.getEmail()%></td>
       <td><%=pojo.getContact()%></td>
       <td><%=pojo.getDesignation()%></td>
       <td><%=pojo.getSalary()%></td></tr>
  <%} %>
  </table>
  <%} %>
  <% if(employee!=null){%>
  <form action="/update" method="post">
    
        <fieldset>
            <legend>Update the record</legend>
            <table>
            <tr>
                <td><%= %></td>
            <td><input type="text" name="id"></td>
            </table>
            </tr>
       </fieldset>
       <input type="submit" value="Update">
   </form>
    
  
	 <% }%>
  
</div>
</body>
</html>