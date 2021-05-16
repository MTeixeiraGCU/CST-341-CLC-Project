<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<h1>
	Welcome ${sessionScope.userName } to the E-Book Store Application!
</h1>
<hr/>

<p>NEW:	Book list view and adding/editing books!</p>
<p>&nbsp &nbsp &nbsp -Login, then <a href="add">Click here</a> to add a new book!
<p>COMING SOON: Book searching and account updating!</p>
<p class="invalid-feedback">${msg}</p>