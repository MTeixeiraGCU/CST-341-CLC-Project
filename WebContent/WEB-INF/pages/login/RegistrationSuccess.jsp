<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="container">
	<h3>Your account has been registered!</h3>
	<hr />
	
	<div class="row">
	<div class="col-md-6 offset-md-3">
		Welcome ${user.getUserName() }!	
		<br>
		<a href="">Go to Home Page</a> <%-- Need to update Home Page Path --%>
		<br>
		<a href="">Logout?</a> <%-- Need to update Logout Path --%>
	</div>
	</div>

</div>