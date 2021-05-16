<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<body>

 <div class="container">
	<h3>Add EBook</h3>
<hr/>
<form:form method="POST" action="addBook" modelAttribute ="book">
	 <div class="form-group">
        <form:label path="title">Title: </form:label>
         <form:input class="form-control" path="title"></form:input> 
        <form:errors path="title"/>
     </div>
        <div class="form-group"> 
         <form:label path="author">Author: </form:label>
          <form:input class="form-control" path="author"></form:input>  
          <form:errors path="author"/>
          </div>
         <div class="form-group">
        <form:label path="ISBN">ISBN: </form:label> 
         <form:input class="form-control" path="ISBN"></form:input> 
         <form:errors path="ISBN"/>
         </div>
        <div class="form-group">
        <form:label path="publisher">Publisher: </form:label>
         <form:input class="form-control" path="publisher"></form:input> 
         <form:errors path="publisher"/>
         </div>
        <div class="invalid-feedback">
        <form:errors path="*" cssClass="error"/>
        </div>
         <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>
