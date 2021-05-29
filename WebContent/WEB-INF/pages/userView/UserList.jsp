<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Administrator User list</h2>

<table style="width:100%" id="users">
  <tr>
    <th>User Name</th>
    <th>First Name</th>
    <th>Last Name</th> 
    <th>E-Mail</th>
    <th>Phone Number</th>
  </tr>
  <c:forEach var="user" items="${users}">
  	
	<tr onclick="window.location.href='editUser?userName=${user.userName}';">
		<td>${user.userName}</td>
		<td>${user.firstName}</td>
		<td>${user.lastName}</td>
		<td>${user.email}</td>
		<td>${user.phoneNumber}</td>
	</tr>

  </c:forEach>
</table>