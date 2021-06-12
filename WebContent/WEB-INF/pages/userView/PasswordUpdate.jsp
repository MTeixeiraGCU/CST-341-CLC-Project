<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-3">
	<h1 class="my-3">Change Password</h1>
	
	<form>
	
		<div class="form-group row">
			<label for="oldPassword" class="col-sm-2 col-form-label">Password:</label>
			<input type="password" id="oldPassword" name="oldPassword" class="form-control" placeHolder="current password" />
		</div>
		
		<div class="form-group row">
			<label for="newPassword" class="col-sm-2 col-form-label">New Password:</label>
			<input type="password" id="newPassword" name="newPassword" class="form-control" placeHolder="" />
		</div>
		
		<div class="form-group row">
			<label for="confirmPassword" class="col-sm-2 col-form-label">Confirm New Password:</label>
			<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeHolder="" />
		</div>
		
		<div class="form-group row">
			<div class="col-sm-4 offset-sm-2">
				<input class="btn btn-primary" id="sub" type="submit" value="Change"/>
			</div>
		</div>
	
	</form>

</div>