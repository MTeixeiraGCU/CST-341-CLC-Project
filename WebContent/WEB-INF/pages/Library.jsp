<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center my-3">
	EBook Library
</h1>

<div class="container mt-3">
	<div class="row">
		<c:forEach var="book" items="${books}" varStatus="counter">
		
			<c:if test="${counter.index % 4 == 0}">
				<c:out value="</div>" escapeXml="false" />
				<c:out value="<div class='row'>" escapeXml="false" />
			</c:if>
			
			<div class="col-sm-3" style="width: 17rem">
				<div class="card">
					<img class="card-img-top" src="../resources/img/${book.image}.png" alt="${book.title}" style="width:100%" onclick="window.location.href='/CLCProject/editBook?isbn=${book.isbn}'">
					<div class="card-body" onclick="window.location.href='/CLCProject/editBook?isbn=${book.isbn}'">
						<h4 class="card-title"><b>${book.title}</b></h4>
						<p class="card-text">Author: ${book.author}</p>
						<p class="card-text">ISBN: ${book.isbn}</p>
						<p class="card-text">Publisher: ${book.publisher}</p>
						<p class="card-text">Publication Date: ${book.publicationDate}</p>
					</div>
					<button class="removeButton" onclick="removeBook('${book.isbn}')">Remove</button>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<script>

	/* script for adding book to library*/
	function removeBook(isbn) {
		$.ajax(
			{
				type: "GET",
				url: "/CLCProject/library/remove?isbn=" + isbn,
				dataType: "json",
				success: function(result)
				{
					if(result) {
						alert("Book was removed from your library!");
						window.location.reload();
					}
					else {
						alert("Could not remove book from your library!");
					}
				},
				error: function (xhr, ajaxOptions, thrownError) 
				{
					alert(xhr.status);
					alert(thrownError);
				}
			}
		);		
	}
</script>