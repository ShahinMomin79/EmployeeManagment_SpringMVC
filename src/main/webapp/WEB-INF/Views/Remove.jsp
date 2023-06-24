<%@page import="com.jspiders.SpringMVC.POJO.EmployeePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Navbar.jsp" />
    <%String msg=(String)request.getAttribute("msg");
    List<EmployeePOJO> employees=(List<EmployeePOJO>)request.getAttribute("empList");%>
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
<form action="./remove" method="post">
     <fieldset>
          <legend>Remove data</legend>
          <table>
               <tr><td>Remove the record</td>
                   <td><input type="text" name="id"></td>
           </tr>
          </table>
     </fieldset>
     <input type="submit" value="Remove">
     </form>
     <%if(msg!=null){ %>
     <h3><%=msg %></h3>
     <%} %>
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
</div>
</body>
</html>