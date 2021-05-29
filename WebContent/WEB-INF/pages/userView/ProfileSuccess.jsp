<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <div class="container">
	<h3>${user.userName}'s Profile Was Updated Successfully!</h3>
	<hr />
	
	<div class="row">
	<div class="col-md-6 offset-md-3">
		<br>
		<a href="editUser?userName=${user.userName}">Go back to Profile Page</a>
		<br>
		<a href="userList">Return to user List</a>	
		<br>
		<a href="index">Home Page</a> 
		<br>
		<a href="logout">Logout?</a> 
	</div>
	</div>

</div>