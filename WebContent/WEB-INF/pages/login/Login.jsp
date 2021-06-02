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
					
					<tr class="form-group">
				    	<td><form:label id="username" path="userName">User Name: </form:label></td> 
				        <td><form:input id="username" path="userName"/></td>
				        <td>
				        	<div class="invalid-feedback">
				        		<form:errors path="userName" />
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
	 			    
	 			     <tr>
	 			     	<td>
	 			    		<div class="invalid-feedback">
				        		${msg}
			        		</div>
			        	</td>
			         </tr>
			    </table>
		        <input class="btn btn-primary" type="submit" value="Submit"/>
		  	</form:form>
		
		</div>
	</div>
</div>

<script>
$(document).ready(function(){  
        $( "input#username" ).focus(function() {
        	$("label#username").css("font-size", "20px");
        	
    });
  });
  </script>
