<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

 <div class="container">
	<h3>Edit Profile</h3>
	<hr/>
<form:form method="POST" action="editUser" modelAttribute ="user">
		 <table style="with: 80%">
			 <tr>
			 	<div class="form-group">
			        <td> <form:label path="firstName">First Name: </form:label> </td>
			        <td> <form:input class="form-control" path="firstName"></form:input> </td> 
			        <td> <form:errors path="firstName"/> </td>
		        </div>
		     </tr>
		     
		     <tr>
	            <div class="form-group">
		            <td> <form:label path="lastName">Last Name: </form:label> </td>
		            <td> <form:input class="form-control" path="lastName"></form:input> </td>  
		            <td> <form:errors path="lastName"/> </td>
	            </div>
	         </tr>
	         
	         <tr>
		         <div class="form-group">
			         <td> <form:label path="email">E Mail: </form:label> </td> 
			         <td> <form:input class="form-control" path="email"></form:input> </td> 
			         <td> <form:errors path="email"/> </td>
		         </div>
	         </tr>
	         <tr>
		         <div class="form-group">
			         <td> <form:label path="phoneNumber">Phone Number: </form:label> </td>
			         <td> <form:input class="form-control" path="phoneNumber"></form:input> </td> 
			         <td> <form:errors path="phoneNumber"/> </td>
		         </div>
	         </tr>
	         
	        <tr>
		        <div class="invalid-feedback">
		        	<td><form:errors path="*" cssClass="error"/></td>
		        </div>
	        </tr>
        </table>
        
		<input class="btn btn-primary" type="submit" value="Submit"/>
	</form:form>
</div>
    