<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div style="padding-left:16px">
  <h2>TOP TREANDING TITLES</h2>
  <p>Welcome, millions of clients are chiming into our site to review the newest titles available for download today! Our team of expert are always researching high demand of titles that our clients are in search of and willing to provide nothing but the best for consumers to read.</p>
  <p>If you are ready to start reviewing the most popular titles, please start downloading now.</p>
</div>

<h2>Book search and selection</h2>
<p>Click on the button to open the dropdown menu, and use the input field to search for a specific book title.</p>

<div class="dropdown">
  <button onclick="myFunction()" class="dropbtn">Browse Books</button>
  <div id="myDropdown" class="dropdown-content">
    <input type="text" placeholder="Search.." id="myInput" onkeyup="filterFunction()"/>
    <c:forEach var="book" items="${books}" varStatus="counter">
    	<a href="editBook?isbn=${book.isbn}">${book.title}</a>
    </c:forEach>

  </div>
</div>

<table class="bookCards">
	<tr>
			<c:forEach var="book" items="${books}" varStatus="counter">
			
				<!-- Check for incomplete row of cards at the end of the list and close that row -->
				<c:if test="${not counter.first and counter.index % 3 == 0}">
					<c:out value="</tr>" escapeXml="false" />
					<c:out value="<tr>" escapeXml="false" />
				</c:if>
					
				<td>
					<div class="card">
						
		 					<img src="resources/img/defaultBook.png" alt="${book.title}" style="width:100%">
		 					<div class="container">
			   					<h4><b>${book.title}</b></h4>
			   					<p>Author: ${book.author}</p>
			   					<p>ISBN: ${book.isbn}</p>
			   					<p>Publisher: ${book.publisher}</p>
			   					<p>Publication Date: ${book.publicationDate}</p>
		 					</div>
		 					<a class="addButton" href="#">Add</a>
		 					<c:if test="${sessionScope.admin}" >
		 						<a class="editButton" href="editBook?isbn=${book.isbn}" >Edit</a>
		 					</c:if>
					</div>
				</td>
				
			</c:forEach>
			
	</tr>
	
</table>

<script>

	/* When the user clicks on the button,
	toggle between hiding and showing the dropdown content */
	function myFunction() {
	  document.getElementById("myDropdown").classList.toggle("show");
	  div = document.getElementById("myDropdown");
	  a = div.getElementsByTagName("a");
	  for (i = 0; i < a.length; i++) {
		  if(i > 4) {
			  a[i].style.display = "none";
		  }
	  }
	}
	
	function filterFunction() {
	  var input, filter, ul, li, a, i, counter;
	  counter = 0;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  div = document.getElementById("myDropdown");
	  a = div.getElementsByTagName("a");
	  for (i = 0; i < a.length; i++) {
	    txtValue = a[i].textContent || a[i].innerText;
	    if (txtValue.toUpperCase().indexOf(filter) > -1 && counter < 5) {
	      a[i].style.display = "";
	      counter++;
	    } else {
	      a[i].style.display = "none";
	    }
	  }
	}
</script>