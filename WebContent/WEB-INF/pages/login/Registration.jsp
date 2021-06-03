<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
	<h3>User Registration</h3>
	<hr/>
	
	<form:form method="POST" action="registerUser" modelAttribute ="user">
		<table style="with: 80%">
		
			<tr class="form-group">
		         <td><form:label path="firstName" >First Name: </form:label></td>
		         <td><form:input path="firstName"/></td> 
		         <td>
		         	<div class="invalid-feedback">
			        	<form:errors path="firstName" />
			    	</div>
			     </td>
			</tr>        
			
			<tr class="form-group">
		         <td><form:label path="lastName">Last Name: </form:label></td> 
		         <td><form:input  path="lastName"/></td>
		         <td>
		         	<div class="invalid-feedback">
		        		<form:errors path="lastName" />
		        	</div>
		        </td>
			</tr>
	 		
	 		<tr class="form-group">
		         <td><form:label path="email">Email: </form:label></td>
		         <td><form:input class="" path="email"/></td> 
		         <td>
		         	<div class="invalid-feedback">
			        	<form:errors path="email" />
			    	</div>
	        	 </td>
			</tr>
			
			<tr class="form-group">
		         <td><form:label path="phoneNumber">Phone Number: </form:label></td>
	        	 <td><form:input path="phoneNumber"/></td> 
	        	 <td>
	        	 	<div class="invalid-feedback">
	        			<form:errors path="phoneNumber" />
	        		</div>
	        	 </td>
	 		</tr>
	 		
	 		<tr class="form-group">        
		         <td><form:label path="userName">User Name: </form:label></td>
		         <td><form:input path="userName"/></td> 
		         <td>
		         	<div class="invalid-feedback">
		        		<form:errors path="userName"/>
		        	</div>
		         </td>
	 		</tr>
	 		
	 		<tr class="form-group">        
		        <td><form:label path="password">Password: </form:label></td>
		         <td><form:password path="password"/></td> 
		         <td>
		         	<div class="invalid-feedback">
		        		<form:errors path="password" />
		        	</div>
		         </td>
			</tr>   
			
			<tr class="form-group">
				<td><p class="invalid-feedback">${msg}</p></td>
			</tr>
			
		</table>
        <input type="submit" class="btn btn-primary" value="Submit" />
        
	</form:form>
</div>
