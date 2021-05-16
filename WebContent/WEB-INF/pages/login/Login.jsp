<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
	<h3>Login</h3>
	<hr />
	
	<div class="row">
		<div class="col-md-6 offset-md-3">
					<form:form method="POST" action="loginUser" modelAttribute ="user">		    
					 <table style="with: 80%">
						
						<tr>
				         <td><div class="form-group"></td>
					         <td><form:label path="userName">User Name: </form:label></td> 
					         <td><form:input path="userName"/></td>
					         <td><div class="invalid-feedback"></td>
					        	 <td><form:errors path="userName" /></td>
				        	</div>
				        </div>
						</tr>
						
						 <tr>
				         <td><div class="form-group"></td>
					         <td><form:label path="password">Password: </form:label></td>
					         <td><form:password path="password"/></td>
					         <td><div class="invalid-feedback"></td>
					        	 <td><form:errors path="password" /> </td>
				        	</div> 
		 			    </div>
		 			     </tr>
		 			    
		 			     <tr>
		 			    <div class="invalid-feedback">
					        	${msg}
				        </div>
				         </tr>
				           </table>
				        <input class="btn btn-primary" type="submit" value="Submit"/>
				  	</form:form>
		
		</div>
	</div>
</div>
