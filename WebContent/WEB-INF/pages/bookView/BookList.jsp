<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="container mt-3">
  <h2>TOP TREANDING TITLES</h2>
  <p>Welcome, millions of clients are chiming into our site to review the newest titles available for download today! Our team of expert are always researching high demand of titles that our clients are in search of and willing to provide nothing but the best for consumers to read.</p>
  <p>If you are ready to start reviewing the most popular titles, please start downloading now.</p>


	<h2 class="text-center my-3">Book search and selection</h2>
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
</div>

<div class="container mt-3">
	<div class="row">
		<c:forEach var="book" items="${books}" varStatus="counter">
			<c:if test="${counter.index % 4 == 0}">
				<c:out value="</div>" escapeXml="false"/>
				<c:out value="<div class='row'>" escapeXml="false"/>
			</c:if>
			
			<div class="col-sm-3" style="width: 17rem">
				<div class="card">
 					<img src="resources/img/${book.image}.png" alt="${book.title}" class="card-img-top" onclick="window.location.href='/CLCProject/editBook?isbn=${book.isbn}'">
 					<div class="card-body" onclick="window.location.href='/CLCProject/editBook?isbn=${book.isbn}'">
	   					<h4 class="card-title"><b>${book.title}</b></h4>
	   					<p class="card-text">Author: ${book.author}</p>
	   					<p class="card-text">ISBN: ${book.isbn}</p>
	   					<p class="card-text">Publisher: ${book.publisher}</p>
	   					<p class="card-text">Publication Date: ${book.publicationDate}</p>
 					</div>
 					<button class="addButton" onclick="addBook('${book.isbn}')">Add</button>
 					<c:if test="${sessionScope.admin}" >
 						<a class="editButton" href="editBook?isbn=${book.isbn}" >Edit</a>
 					</c:if>
 				</div>
			</div>
		</c:forEach>
	</div>
</div>

<script>

	/* script for adding book to library*/
	function addBook(isbn) {
		$.ajax(
			{
				type: "GET",
				url: "/CLCProject/library/add?isbn=" + isbn,
				dataType: "json",
				success: function(result)
				{
					if(result) {
						alert("Book was added successfully!");
					}
					else {
						alert("Could not add book to your library!");
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