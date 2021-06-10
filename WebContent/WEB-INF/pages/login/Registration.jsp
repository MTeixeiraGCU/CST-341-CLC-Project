<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-3">
	<h3 class="my-3">User Registration</h3>
	<hr/>
	
	<form:form method="POST" action="registerUser" modelAttribute ="user">
		
		<!-- Bindings for server-side errors -->
		<c:set var="firstNameHasBindError">
			<form:errors path="firstName" />
		</c:set>
		<c:set var="lastNameHasBindError">
			<form:errors path="lastName" />
		</c:set>
		<c:set var="emailHasBindError">
			<form:errors path="email" />
		</c:set>
		<c:set var="phoneNumberHasBindError">
			<form:errors path="phoneNumber" />
		</c:set>
		<c:set var="userNameHasBindError">
			<form:errors path="userName" />
			${msg}
		</c:set>
		<c:set var="passwordHasBindError">
			<form:errors path="password" />
		</c:set>
		
		<div class="form-group row">
	         <form:label id="firstname" path="firstName" class="col-sm-2 col-form-label">First Name: </form:label>
	         <div class="col-sm-10">
	         	<form:input id="firstname" path="firstName" class="form-control ${not empty firstNameHasBindError?'is-invalid':''}"/> 
	         	<div class="invalid-feedback">
		        	${firstNameHasBindError}
		    	</div>
		     </div>
		</div>        
		
		<div class="form-group row">
	         <form:label id="lastname" path="lastName" class="col-sm-2 col-form-label">Last Name: </form:label> 
	         <div class="col-sm-10">
	         	<form:input id="lastname" path="lastName" class="form-control ${not empty lastNameHasBindError?'is-invalid':''}"/>
	         	<div class="invalid-feedback">
	        		${lastNameHasBindError}
	        	</div>
	        </div>
		</div>
			
		<div class="form-group row">
	         <form:label id="email" path="email" class="col-sm-2 col-form-label">Email: </form:label>
	         <div class="col-sm-10">
	         	<form:input id="email" path="email" class="form-control ${not empty emailHasBindError?'is-invalid':''}"/>
	         	<div class="invalid-feedback">
		        	${emailHasBindError}
		    	</div>
	       	 </div>
		</div>
		
		<div class="form-group row">
	         <form:label id="phonenumber" path="phoneNumber" class="col-sm-2 col-form-label">Phone Number: </form:label>
	         <div class="col-sm-10">
	       	 	<form:input id="phonenumber" path="phoneNumber" class="form-control ${not empty phoneNumberHasBindError?'is-invalid':''}"/>
	       	 	<div class="invalid-feedback">
	       			${phoneNumberHasBindError}
	       		</div>
	       	 </div>
		</div>
			
		<div class="form-group row">        
	         <form:label id="username" path="userName" class="col-sm-2 col-form-label">User Name: </form:label>
	         <div class="col-sm-10">
	         	<form:input id="username" path="userName" class="form-control ${not empty userNameHasBindError?'is-invalid':''}"/>
	         	<div class="invalid-feedback">
	        		${userNameHasBindError}
	        	</div>
	         </div>
		</div>
			
		<div class="form-group row">        
	        <form:label id="pass" path="password" class="col-sm-2 col-form-label">Password: </form:label>
	        <div class="col-sm-10">
	        	<form:password id="pass" path="password" class="form-control ${not empty passwordHasBindError?'is-invalid':''}"/>
	         	<div class="invalid-feedback">
	        		${passwordHasBindError}
	        	</div>
	         </div>
		</div>   
			
		<div class="form-group row">
			<div class="col-sm-6 offset-sm-2">
        		<input type="submit" class="btn btn-primary" id="sub" value="Submit" />
        	</div>
        </div>
        
	</form:form>
</div>

<script>
$(document).ready(function(){
	  
	  $("input#sub").mouseover(function(){
		  $(this).stop();
		  $(this).animate({"font-size": "18px"}, 250);
	  });
	  
	  $("input#sub").mouseout(function(){
		  $(this).stop();
		  $(this).animate({"font-size": "16px"}, 250);
	  });
});
</script>