<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-3">

	<h3 class="my-3">Login</h3>
	<hr />
	
	<form:form method="POST" action="loginUser" modelAttribute ="user">		    
			
		<!-- Binding for server-side form errors -->
		<c:set var="userNameHasBindError">
			<form:errors path="userName" />
		</c:set>
		<c:set var="passwordHasBindError">
			<form:errors path="password" />
		</c:set>
		
		
		<!-- Form fields -->
		<div class="form-group row">
	    	<form:label id="username" path="userName" class="col-sm-2 col-form-label">UserName: </form:label>
	    	<div class="col-sm-8"> 
	        	<form:input id="username" path="userName" class="form-control ${not empty userNameHasBindError?'is-invalid':''}"/>
	        	<div class="invalid-feedback">
	        		${userNameHasBindError}
	       		</div>
	       	</div>
		</div>
			
		<div class="form-group row">
	         <form:label id="password" path="password" class="col-sm-2 col-form-label">Password: </form:label>
	         <div class="col-sm-8">
	         	<form:password id="password" path="password" class="form-control ${not empty passwordHasBindError?'is-invalid':''}"/>
	         	<div class="invalid-feedback">
	        		${passwordHasBindError}
	       		</div>
	       	 </div> 
		</div>
			    
	    <div class="form-group row">
	     	<div class="col-sm-4">
	    		<div class="invalid-feedback">
        			${msg}
       			</div>
        	</div>
        </div>

		<div class="form-group row">
			<div class="col-sm-6 offset-sm-2">
        		<input class="btn btn-primary" id="sub" type="submit" value="Submit"/>
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
