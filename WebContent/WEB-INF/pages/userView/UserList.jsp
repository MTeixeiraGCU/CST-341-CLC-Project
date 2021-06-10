<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-3">
	<h2 class="my-3">Administrator User list</h2>
	
	<table class="table table-hover">
		<thead class="thead-dark">
	    	<tr>
	      		<th>User Name</th>
	      		<th>First Name</th>
	      		<th>Last Name</th> 
	      		<th>E-Mail</th>
	      		<th>Phone Number</th>
	      		<th>Role</th>
	    	</tr>
	  	</thead>
	  	<tbody>
		    <c:forEach var="user" items="${users}">
		  	
				<tr class="${(user.role == 1)?'table-primary':''}" onclick="window.location.href='editUser?userName=${user.userName}';">
					<td>${user.userName}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.email}</td>
					<td>${user.phoneNumber}</td>
					<td>${(user.role == 1)?'Admin':'None'}</td>
				</tr>
		
		    </c:forEach>
		</tbody>
	</table>
</div>