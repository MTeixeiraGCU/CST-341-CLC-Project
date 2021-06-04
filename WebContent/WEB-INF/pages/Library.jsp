<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>
	EBook Library
</h1>

<table class="bookCards">
	<tr>
		<c:forEach var="book" items="${books}" varStatus="counter">
		
			<!-- Check for incomplete row of cards at the end of the list and close that row -->
			<c:if test="${not counter.first and counter.index % 4 == 0}">
				<c:out value="</tr>" escapeXml="false" />
				<c:out value="<tr>" escapeXml="false" />
			</c:if>
				
			<td>
				<div class="card">
					
	 					<img src="../resources/img/defaultBook.png" alt="${book.title}" style="width:100%" onclick="window.location.href='/CLCProject/editBook?isbn=${book.isbn}'">
	 					<div class="container" onclick="window.location.href='/CLCProject/editBook?isbn=${book.isbn}'">
		   					<h4><b>${book.title}</b></h4>
		   					<p>Author: ${book.author}</p>
		   					<p>ISBN: ${book.isbn}</p>
		   					<p>Publisher: ${book.publisher}</p>
		   					<p>Publication Date: ${book.publicationDate}</p>
	 					</div>
				</div>
			</td>
			
		</c:forEach>
	</tr>
</table>