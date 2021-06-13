<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div class="container mt-3">
	<h3 class="my-3">Edit Profile</h3>
	<hr/>
	<form:form method="POST" action="editUser" modelAttribute ="user">
	
		<!-- Binding server-side form errors -->
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
	
		<!-- Form fields -->
		<div class="form-group row">
			<form:label path="userName" class="col-sm-2 col-form-label" >User Name: </form:label>
			<div class="col-sm-6">
				<form:input class="form-control" path="userName" readonly="true"/>
			</div>
		</div>
		        
		<div class="form-group row">
			<form:label path="firstName" class="col-sm-2 col-form-label" >First Name: </form:label>
			<div class="col-sm-6">
				<form:input path="firstName" class="form-control ${not empty firstNameHasBindError?'is-invalid':''}" /> 
				<div class="invalid-feedback">
					${firstNameHasBindError}
				</div>
			</div>
		</div>
		
		<div class="form-group row">	     
			<form:label path="lastName" class="col-sm-2 col-form-label" >Last Name: </form:label>
			<div class="col-sm-6">
			    <form:input path="lastName" class="form-control ${not empty lastNameHasBindError?'is-invalid':''}" /> 
			    <div class="invalid-feedback">
					${lastNameHasBindError}
				</div>
		    </div>
		</div>
		
		<div class="form-group row">
		    <form:label  path="email" class="col-sm-2 col-form-label" >E-Mail: </form:label>
		    <div class="col-sm-6"> 
				<form:input path="email" class="form-control ${not empty emailHasBindError?'is-invalid':''}" /> 
				<div class="invalid-feedback">
					${emailHasBindError}
				</div>
			</div>
		</div>
			         
		<div class="form-group row">
		    <form:label path="phoneNumber" class="col-sm-2 col-form-label" >Phone Number: </form:label>
		    <div class="col-sm-6">
				<form:input path="phoneNumber" class="form-control ${not empty phoneNumberHasBindError?'is-invalid':''}" ></form:input> 
				<div class="invalid-feedback">
					${phoneNumberHasBindError}
				</div>
			</div>
		</div>
		
		<div class="form-group row">
		    <form:label path="role" class="col-sm-2 col-form-label" >Role: </form:label>
		    <div class="col-sm-6">
			    <form:select path="role" id="role" class="form-control" >
			    	<form:option value="0" label="None" />
			        <form:option value="1" label="Admin" /> 
			    </form:select>
		    </div>
		</div>         
	        
	    <div class="form-group row">
	    	<div class="col-sm-6 offset-sm-2">
				<input class="btn btn-primary" type="submit" value="Submit"/>
			</div>
		</div>
		
	</form:form>
	
	<div class="row">
		<div class="col-sm-6 offset-sm-2">
			<button class="btn btn-primary" onclick="window.location.href='changePassword'">Change password</button>
		</div>
	</div>
	
</div>

<script>
function setup() {
	
	//hide some fields from none-admins
	if(!${sessionScope.admin}) {
		$("label#role").attr("hidden", "true");
		$("select#role").attr("hidden", "true");
	}
}

$(document).ready(setup);
</script>
    