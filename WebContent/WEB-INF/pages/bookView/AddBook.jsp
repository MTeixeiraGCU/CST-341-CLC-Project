<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div class="container mt-3">
	<h3 class="text-center my-3">Add/Edit EBook</h3>
	<hr/>
	<form:form method="POST" action="addBook" modelAttribute ="eBook">
	
		<!-- Bindings for server side form errors -->
		<c:set var="titleHasBindError">
			<form:errors path="title"/>
		</c:set>
		<c:set var="authorHasBindError">
			<form:errors path="author"/>
		</c:set>
		<c:set var="isbnHasBindError">
			<form:errors path="isbn"/>
		</c:set>
		<c:set var="publisherHasBindError">
			<form:errors path="publisher"/>
		</c:set>
		
		<!-- Form fields -->
		<div class="form-group row">
	     	<form:label path="title" class="col-sm-2 col-form-label">Title: </form:label>
	     	<div class="col-sm-10">
		     	<form:input class="form-control ${not empty titleHasBindError?'is-invalid':''}" path="title"/>
	     		<div class="invalid-feedback">
		        	${titleHasBindError}
		        </div>
	        </div>
		</div>
		     
	    <div class="form-group row">
	    	<form:label path="author" class="col-sm-2 col-form-label">Author: </form:label>
	        <div class="col-sm-10">
	        	<form:input class="form-control ${not empty authorHasBindError?'is-invalid':''}" path="author" />
	        	<div class="invalid-feedback">
		        	<form:errors path="author"/>
		        </div>
			</div>
	    </div>
	          
        <div class="form-group row">
        	<form:label path="isbn" class="col-sm-2 col-form-label">ISBN: </form:label> 
        	<div class="col-sm-10">
        		<form:input class="form-control ${not empty isbnHasBindError?'is-invalid':''}" path="isbn" /> 
        		<div class="invalid-feedback">
	        		<form:errors path="isbn"/>
	        	</div>
			</div>
        </div>
	         
        <div class="form-group row">
        	<form:label path="publisher" class="col-sm-2 col-form-label">Publisher: </form:label>
        	<div class="col-sm-10">
        		<form:input class="form-control ${not empty publisherHasBindError?'is-invalid':''}" path="publisher" />
        		<div class="invalid-feedback">
	        		<form:errors path="publisher"/>
	        	</div>
			</div>
        </div>
        
        <div class="form-group row">
        	<div class="col-sm-10 offset-sm-2">
				<input id="submitButton" class="btn btn-primary" type="submit" value="Submit"/>
			</div>
		</div>
		
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


