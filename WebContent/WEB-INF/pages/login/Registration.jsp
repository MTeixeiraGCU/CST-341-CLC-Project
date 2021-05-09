<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
	<h3>User Registration</h3>
	<hr/>
	
	<form:form method="POST" action="registerUser" modelAttribute ="user">

    	<div class="form-group">
	        <form:label path="firstName" >First Name: </form:label>
	        <form:input path="firstName"/> 
	        <div class="invalid-feedback">
		        <form:errors path="firstName" />
		    </div>
	    </div>
        
        <div class="form-group">
	        <form:label path="lastName">Last Name: </form:label> 
	        <form:input  path="lastName"/>
	        <div class="invalid-feedback">
	        	<form:errors path="lastName" />
	        </div>
        </div>

        <div class="form-group">
	        <form:label path="email">Email: </form:label>
	        <form:input class="" path="email"/> 
	        <div class="invalid-feedback">
		        <form:errors path="email" />
		    </div>
        </div>
        
        <div class="form-group">
	        <form:label path="phoneNumber">Middle Initial: </form:label>
        	<form:input path="phoneNumber"/> 
        	<div class="invalid-feedback">
        		<form:errors path="phoneNumber" />
        	</div>
        </div>
        
		<div class="form-group">
	        <form:label path="userName">User Name: </form:label>
	        <form:input path="userName"/> 
	        <div class="invalid-feedback">
	        	<form:errors path="userName"/>
	        </div>
        </div>
        
        <div class="form-group">
	        <form:label path="password">Password: </form:label>
	        <form:input path="password"/> 
	        <div class="invalid-feedback">
	        	<form:errors path="password" />
	        </div>
        </div>
        
        <input type="submit" class="btn btn-primary" value="Submit" />
        
	</form:form>
</div>
