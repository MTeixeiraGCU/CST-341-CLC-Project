<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<h1 class="text-center my-3">
	Welcome ${sessionScope.userName } to the E-Book Store Application!
</h1>

<hr/>
<div class="container">
	
	<p>NEW: User can now update and change their password.</p>
	<p>NEW: The book list now contains a variety of unique images to show of the card system that it uses.</p> 
	<p>NEW: Users can now remove books from their library.</p>
	
	<p>Admins can add new books to the database <a href="add">Here.</a>!</p>

	<p class="invalid-feedback">${msg}</p>
</div>