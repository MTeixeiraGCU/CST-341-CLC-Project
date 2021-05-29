<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <div class="container">
	<h3>Profile Updated Successfully!</h3>
	<hr />
	
	<div class="row">
	<div class="col-md-6 offset-md-3">
		Welcome ${user.getUserName() }!	
		<br>
		<a href="index">Go to Home Page</a> 
		<br>
		<a href="logout">Logout?</a> 
	</div>
	</div>

</div>