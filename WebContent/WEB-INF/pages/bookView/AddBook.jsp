<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

 <div class="container">
	<h3>Add/Edit EBook</h3>
	<hr/>
<form:form method="POST" action="addBook" modelAttribute ="eBook">
		 <table style="with: 80%">
		 
			 <tr class="form-group">
		     	<td><form:label path="title">Title: </form:label></td>
		     	<td> <form:input class="form-control" path="title" ></form:input></td> 
		     	<td>
		     		<div class="invalid-feedback">
			        	<form:errors path="title"/>
			        </div>
			    </td>
		     </tr>
		     
		     <tr class="form-group">
	         	<td><form:label path="author">Author: </form:label></td>
	         	<td><form:input class="form-control" path="author" ></form:input></td>  
	         	<td>
	         		<div class="invalid-feedback">
			        	<form:errors path="author"/>
			        </div>
			    </td>
	         </tr>
	          
	         <tr class="form-group">
	         	<td><form:label path="isbn">ISBN: </form:label></td> 
	         	<td><form:input class="form-control" path="isbn" ></form:input></td> 
	         	<td>
	         		<div class="invalid-feedback">
			        	<form:errors path="isbn"/>
			        </div>
			    </td>
	         </tr>
	         
	         <tr class="form-group">
	         	<td><form:label path="publisher">Publisher: </form:label></td>
	         	<td><form:input class="form-control" path="publisher" ></form:input></td> 
	         	<td>
	         		<div class="invalid-feedback">
			        	<form:errors path="publisher"/>
			        </div>
			    </td>
	         </tr>
         
        </table>
		<input id="submitButton" class="btn btn-primary" type="submit" value="Submit"/>
		
	</form:form>
</div>

<script>
	 function setup(){
		if(!${sessionScope.admin}) {
			$("input.form-control").attr("readonly", "true");
			$("input.form-control").attr("disabled", "true");
			$("input#submitButton").attr("hidden", "true");
		}
	 }
	
	$(document).ready(setup);
</script>


