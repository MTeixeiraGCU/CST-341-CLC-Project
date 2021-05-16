<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
	<h3>User Registration</h3>
	<hr/>
	
	<form:form method="POST" action="registerUser" modelAttribute ="user">
		<table style="with: 80%">
		
		<tr>
    	 <td><div class="form-group"></td>
	         <td><form:label path="firstName" >First Name: </form:label></td>
	         <td><form:input path="firstName"/></td> 
	         <td><div class="invalid-feedback"></td>
		        <td><form:errors path="firstName" /></td>
		    </div>
	    </div>
		</tr>        
		
		<tr>
         <td><div class="form-group"></td>
	         <td><form:label path="lastName">Last Name: </form:label></td> 
	         <td><form:input  path="lastName"/></td>
	         <td><div class="invalid-feedback"></td>
	        	 <td><form:errors path="lastName" /></td>
	        </div>
        </div>
		</tr>
 		
 		<tr>
         <td><div class="form-group"></td>
	         <td><form:label path="email">Email: </form:label></td>
	         <td><form:input class="" path="email"/></td> 
	        <td><div class="invalid-feedback"></td>
		         <td><form:errors path="email" /></td>
		    </div>
        </div>
		</tr>
		
		<tr>
         <td><div class="form-group"></td>
	         <td><form:label path="phoneNumber">Phone Number: </form:label></td>
        	 <td><form:input path="phoneNumber"/></td> 
        	 <td><div class="invalid-feedback"></td>
        		 <td><form:errors path="phoneNumber" /></td>
        	</div>
        </div>
 		</tr>
 		
 		<tr>        
		 <td><div class="form-group"></td>
	         <td><form:label path="userName">User Name: </form:label></td>
	         <td><form:input path="userName"/></td> 
	         <td><div class="invalid-feedback"></td>
	        	 <td><form:errors path="userName"/></td>
	        </div>
        </div>
 		</tr>
 		
 		<tr>        
         <td><div class="form-group"></td>
	        <td><form:label path="password">Password: </form:label></td>
	         <td><form:password path="password"/></td> 
	         <td><div class="invalid-feedback"></td>
	        	 <td><form:errors path="password" /></td>
	        </div>
        </div>
		</tr>    
		</table>
        <input type="submit" class="btn btn-primary" value="Submit" />
        
	</form:form>
</div>
