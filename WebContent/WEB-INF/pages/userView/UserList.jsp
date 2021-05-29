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
  	
	<tr>
		<td><a href="editUser?userName=${user.userName}">${user.userName}</a></td>
		<td><a href="editUser?userName=${user.userName}">${user.firstName}</a></td>
		<td><a href="editUser?userName=${user.userName}">${user.lastName}</a></td>
		<td><a href="editUser?userName=${user.userName}">${user.email}</a></td>
		<td><a href="editUser?userName=${user.userName}">${user.phoneNumber}</a></td>
	</tr>

  </c:forEach>
</table>