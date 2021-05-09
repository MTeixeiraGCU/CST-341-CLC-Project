<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
<h3>Login</h3>
<hr />
<div class="row">
<div class="col-md-6 offset-md-3">
			<form:form method="POST" action="loginUser" modelAttribute ="user">		    
		        <div class="form-group">
			        <form:label path="userName">User Name: </form:label> 
			        <form:input path="userName"/>
			        <div class="invalid-feedback">
			        	<form:errors path="userName" />
		        	</div>
		        </div>
		        <div class="form-group">
			        <form:label path="password">Password: </form:label> 
			        <form:input path="password"/>
			        <div class="invalid-feedback">
			        	<form:errors path="password" />
		        	</div> 
 			    </div>
		        <input class="btn btn-primary" type="submit" value="Submit"/>
		  	</form:form>
</div>
	

</div>
