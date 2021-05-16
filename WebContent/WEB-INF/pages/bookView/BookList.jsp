<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div style="padding-left:16px">
  <h2>TOP TREANDING TITLES</h2>
  <p>Welcome, millions of clients are chiming into our site to review the newest titles avalible for download today! Our team of expert are always researching high demand of titles that our clients are in search of and willing to provide nothing but the best for consumers to read.</p>
  <p>If you are ready to start reviewing the most popular titles, please start downloading now.</p>
</div>


<div class="card">
  <img src="EXAMPLE IMG" alt="IMG" style="width:100%">
  <div class="container">
    <h4><b>John Doe</b></h4>
    <p>Architect & Engineer</p>
  </div>
</div>

<table>
	<tr>
		<td>
			<c:forEach var="book" items="${books}" varStatus="counter">
			
				<c:if test="not counter.first and counter.index % 3 == 0">
		</td>
	</tr>
	<tr>
		<td>
				</c:if>	
				
				<div class="card">
  					<img src="img/defaultBook.png" alt="${book.title}" style="width:100%">
  					<div class="container">
    					<h4><b>${book.title}</b></h4>
    					<p>Author: ${book.author}</p>
    					<p>Publisher: ${book.publisher}</p>
    					<p>Publication Date: ${book.publicationDate}</p>
  					</div>
				</div>
			
			</c:forEach>
			
		</td>
	</tr>
	
</table>