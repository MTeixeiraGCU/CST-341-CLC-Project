<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<h1 class="text-center my-3">
	Welcome ${sessionScope.userName } to the E-Book Store Application!
</h1>

<hr/>
<div class="container">
	<p>NEW: Login, then <a href="add">Click here</a> to add a new book!
	<p>NEW: Delete Users/Books from database. Use "/removeUser?userName=NameHere" to remove users and "/removeBook?isbn=ISBNHere" for books.</p>
	<p>NEW: Library page for each user to see their selected ebooks.</p>
	<p>NEW: Users can now add books to their library from the book list page.

	<p class="invalid-feedback">${msg}</p>
</div>