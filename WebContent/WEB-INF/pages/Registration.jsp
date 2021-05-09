<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
	<h3>User Registration</h3>
<hr/>
		<form:form method="POST" action="registerUser" modelAttribute ="user">
			<div class="form-row">
	    	<div class="form-group col-md-5">
		        <form:label path="firstName" for="inputFirstName">First Name: </form:label>
		        <form:input class="" id="inputFirstName" path="firstName"/> 
		        <div class="invalid-feedback">
			        <form:errors path="firstName" />
			    </div>
		    </div>
	        
	        <div class="form-group col-md-5">
		        <form:label path="lastName" for="inputLastName">Last Name: </form:label> 
		        <form:input class="" id="inputLastName" path="lastName"/>
		        <div class="invalid-feedback">
		        	<form:errors path="lastName" />
		        </div>
	        </div>
	        </div>
	        <div class="form-group">
		        <form:label path="email">Email: </form:label>
		        <form:input class="" path="email"/> 
		        <div class="invalid-feedback">
			        <form:errors path="email" />
			    </div>
	        </div>
	        <div class="form-group col-md-2">
		        <form:label path="phoneNumber" for="inputphoneNumber">Middle Initial: </form:label>
	        	<form:input class="" id="inputphoneNumber"  path="phoneNumber"/> 
	        	<div class="invalid-feedback">
	        		<form:errors path="phoneNumber" />
	        	</div>
	        </div>
			<div class="form-group">
		        <form:label path="userName">User Name: </form:label>
		        <form:input class="" path="userName"/> 
		        <div class="invalid-feedback">
		        	<form:errors path="userName"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <form:label path="password">Password: </form:label>
		        <form:input class="" path="password"/> 
		        <div class="invalid-feedback">
		        	<form:errors path="password" />
		        </div>
	        </div>
	        <!--
	     	<div class="form-group">
		        <form:label path="passwordConfirmation">Confirm Password: </form:label>
		        <form:input class="" path="passwordConfirmation"/> 
		        <div class="invalid-feedback">
			        <form:errors path="passwordConfirmation" />
	        	</div>
	        </div>
	        -->
	        <input type="submit" class="btn btn-primary" value="Submit" />
		</form:form>
</div>
