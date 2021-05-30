<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

 <div class="container">
	<h3>Edit Profile</h3>
	<hr/>
<form:form method="POST" action="editUser" modelAttribute ="user">
		 <table style="with: 80%">
			 <tr>
			 	
		        <td> <form:input class="form-control" path="userName" hidden="true"></form:input> </td> 
		        
		     </tr>
		     
		     <tr>
			 	
		        <td> <form:input class="form-control" path="password" hidden="true"></form:input> </td>
		        
		     </tr>
		     
		     <tr>
			 	
		        <td> <form:label path="firstName">First Name: </form:label> </td>
		        <td> <form:input class="form-control" path="firstName"></form:input> </td> 
		        <td> <form:errors path="firstName"/> </td>
		        
		     </tr>
		     
		     <tr>
	            
	            <td> <form:label path="lastName">Last Name: </form:label> </td>
	            <td> <form:input class="form-control" path="lastName"></form:input> </td>  
	            <td> <form:errors path="lastName"/> </td>
	            
	         </tr>
	         
	         <tr>
		         
		         <td> <form:label path="email">E Mail: </form:label> </td> 
		         <td> <form:input class="form-control" path="email"></form:input> </td> 
		         <td> <form:errors path="email"/> </td>
		         
	         </tr>
	         <tr>
		         
		         <td> <form:label path="phoneNumber">Phone Number: </form:label> </td>
		         <td> <form:input class="form-control" path="phoneNumber"></form:input> </td> 
		         <td> <form:errors path="phoneNumber"/> </td>
		         
	         </tr>
	         
	        <tr>
	        	<td>
			        <div class="invalid-feedback">
			        	<form:errors path="*" cssClass="error"/>
			        </div>
		        </td>
	        </tr>
        </table>
        
		<input class="btn btn-primary" type="submit" value="Submit"/>
	</form:form>
</div>
    