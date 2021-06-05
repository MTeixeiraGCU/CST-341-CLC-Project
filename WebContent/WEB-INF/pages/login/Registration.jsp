<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
	<h3>User Registration</h3>
	<hr/>
	
	<form:form method="POST" action="registerUser" modelAttribute ="user">
		<table style="with: 80%">
		
			<tr class="form-group">
		         <td><form:label id="firstname" path="firstName" >First Name: </form:label></td>
		         <td><form:input id="firstname" path="firstName"/></td> 
		         <td>
		         	<div class="invalid-feedback">
			        	<form:errors path="firstName" />
			    	</div>
			     </td>
			</tr>        
			
			<tr class="form-group">
		         <td><form:label id="lastname" path="lastName">Last Name: </form:label></td> 
		         <td><form:input id="lastname" path="lastName"/></td>
		         <td>
		         	<div class="invalid-feedback">
		        		<form:errors path="lastName" />
		        	</div>
		        </td>
			</tr>
	 		
	 		<tr class="form-group">
		         <td><form:label id="mail" path="email">Email: </form:label></td>
		        
		         <td><form:input class="" id="mail" path="email"/></td> 
		         <td>
		         	<div class="invalid-feedback">
			        	<form:errors path="email" />
			    	</div>
	        	 </td>
			</tr>
			
			<tr class="form-group">
		         <td><form:label id="phonenumber" path="phoneNumber">Phone Number: </form:label></td>
	        	 <td><form:input id="phonenumber" path="phoneNumber"/></td> 
	        	 <td>
	        	 	<div class="invalid-feedback">
	        			<form:errors path="phoneNumber" />
	        		</div>
	        	 </td>
	 		</tr>
	 		
	 		<tr class="form-group">        
		         <td><form:label id="username" path="userName">User Name: </form:label></td>
		         <td><form:input id="username" path="userName"/></td> 
		         <td>
		         	<div class="invalid-feedback">
		        		<form:errors path="userName"/>
		        	</div>
		         </td>
	 		</tr>
	 		
	 		<tr class="form-group">        
		        <td><form:label id="pass" path="password">Password: </form:label></td>
		         <td><form:password id="pass" path="password"/></td> 
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
        <input type="submit" class="btn btn-primary" id="sub" value="Submit" />
        
	</form:form>
</div>
<script>
$(document).ready(function(){
	  $("input#firstname").focus(function(){
		    $("label#firstname").animate({"font-size": "20px"}, 500);
		    $("input#firstname").animate({"font-size": "20px"}, 500);
	  }); 
	  
	  $("input#firstname").blur(function(){
		    $("label#firstname").animate({"font-size": "16px"}, 500);
		    $("input#firstname").animate({"font-size": "16px"}, 500);
	  }); 
	  
	  $("input#lastname").focus(function(){
		    $("label#lastname").animate({"font-size": "20px"}, 500);
		    $("input#lastname").animate({"font-size": "20px"}, 500);
	  }); 
	  
	  $("input#lastname").blur(function(){
		    $("label#lastname").animate({"font-size": "16px"}, 500);
		    $("input#lastname").animate({"font-size": "16px"}, 500);
	  }); 
	  
	  $("input#mail").focus(function(){
		    $("label#mail").animate({"font-size": "20px"}, 500);
		    $("input#mail").animate({"font-size": "20px"}, 500);
	  }); 
	  
	  $("input#mail").blur(function(){
		    $("label#mail").animate({"font-size": "16px"}, 500);
		    $("input#mail").animate({"font-size": "16px"}, 500);
	  }); 
	  $("input#phonenumber").focus(function(){
		    $("label#phonenumber").animate({"font-size": "20px"}, 500);
		    $("input#phonenumber").animate({"font-size": "20px"}, 500);
	  }); 
	  
	  $("input#phonenumber").blur(function(){
		    $("label#phonenumber").animate({"font-size": "16px"}, 500);
		    $("input#phonenumber").animate({"font-size": "16px"}, 500);
	  }); 
	  $("input#username").focus(function(){
		    $("label#username").animate({"font-size": "20px"}, 500);
		    $("input#username").animate({"font-size": "20px"}, 500);
	  }); 
	  
	  $("input#username").blur(function(){
		    $("label#username").animate({"font-size": "16px"}, 500);
		    $("input#username").animate({"font-size": "16px"}, 500);
	  }); 
	  $("input#pass").focus(function(){
		    $("label#pass").animate({"font-size": "20px"}, 500);
		    $("input#pass").animate({"font-size": "20px"}, 500);
	  }); 
	  
	  $("input#pass").blur(function(){
		    $("label#pass").animate({"font-size": "16px"}, 500);
		    $("input#pass").animate({"font-size": "16px"}, 500);
		    $("input#sub").hover(function(){
				  $("label#sub").animate({"font-size": "20px"}, 500);
				  $("input#sub").animate({"font-size": "20px"}, 500);
				  $("input#sub").fadin("background-color:blue");
				  $('.button').animate( { deg: 180 }, {duration: 1200, step: function(now) 
					  {
				  		        $(this).css({ transform: 'rotate(' + now + 'deg)' });
					  }
				    }
				  );
			});
		});
});
</script>