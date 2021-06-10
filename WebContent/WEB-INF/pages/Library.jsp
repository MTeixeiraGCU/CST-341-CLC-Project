<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center my-3">
	EBook Library
</h1>

<div class="container">
	<div class="row">
		<c:forEach var="book" items="${books}" varStatus="counter">
			<div class="col-md-4 col-6 p-1">
				<div class="card h-100">
					<img class="card-img-top" src="../resources/img/defaultBook.png" alt="${book.title}" style="width:100%" onclick="window.location.href='/CLCProject/editBook?isbn=${book.isbn}'">
					<div class="card-body" onclick="window.location.href='/CLCProject/editBook?isbn=${book.isbn}'">
						<h4 class="card-title"><b>${book.title}</b></h4>
						<p class="card-text">Author: ${book.author}</p>
						<p class="card-text">ISBN: ${book.isbn}</p>
						<p class="card-text">Publisher: ${book.publisher}</p>
						<p class="card-text">Publication Date: ${book.publicationDate}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>