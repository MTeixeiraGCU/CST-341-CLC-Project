<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

 <div class="container">
	<h3>Add/Edit EBook</h3>
	<hr/>
<form:form method="POST" action="addBook" modelAttribute ="eBook">
		 <table style="with: 80%">
		 <tr>
		<td><div class="form-group"></td>
	        <td><form:label path="title">Title: </form:label></td>
	        <td> <form:input class="form-control" path="title"></form:input></td> 
	       <td> <form:errors path="title"/></td>
	     </div>
	     </tr>
	     
	      <tr>
         <td><div class="form-group"></td>
          <td><form:label path="author">Author: </form:label></td>
           <td><form:input class="form-control" path="author"></form:input></td>  
          <td> <form:errors path="author"/></td>
          </div>
          </tr>
           <tr>
         <td><div class="form-group"></td>
        <td><form:label path="isbn">ISBN: </form:label></td> 
          <td><form:input class="form-control" path="isbn"></form:input></td> 
         <td> <form:errors path="isbn"/></td>
         </div>
         </tr>
          <tr>
        <td><div class="form-group"></td>
        <td><form:label path="publisher">Publisher: </form:label></td>
         <td><form:input class="form-control" path="publisher"></form:input></td> 
         <td><form:errors path="publisher"/></td>
         </div>
         </tr>
          <tr>
        <td><div class="invalid-feedback"></td>
        <td><form:errors path="*" cssClass="error"/></td>
        </div>
        </tr>
           </table>
		<input class="btn btn-primary" type="submit" value="Submit"/>
	</form:form>
</div>


