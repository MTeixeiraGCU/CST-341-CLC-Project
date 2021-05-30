<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<h1>
	Welcome ${sessionScope.userName } to the E-Book Store Application!
</h1>
<hr/>

<p>NEW: Login, then <a href="add">Click here</a> to add a new book!
<p>NEW:	User list for admins to view.</p>
<p>NEW:	Edit/Save user and eBook information.</p>
<p>NEW: Delete Users/Books from database. Use "/removeUser?userName=NameHere" to remove users and "/removeBook?isbn=ISBNHere" for books.</p>

<p>COMING SOON: Delete Button for the user/Book removal on their respective editing pages.</p>
<p>COMING SOON: Possible eBook cart/library system


<p class="invalid-feedback">${msg}</p>