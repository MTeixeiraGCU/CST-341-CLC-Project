<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md navbar-light bg-light">

	<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
    	<span class="navbar-toggler-icon"></span>
    </button>
	
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<div class="navbar-nav">
			<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/"}'> active</c:if>" href="">Home</a>
			<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/about"}'> active</c:if>" href="/CLCProject/about">About</a>
			<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/contact"}'> active</c:if>" href="/CLCProject/contact">Contact</a>
		</div>
		
		<c:choose>
			<c:when test="${empty sessionScope.userName}">
				<div class="navbar-nav ml-auto">
					<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/login"}'> active</c:if>" href="/CLCProject/login">Login</a>
					<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/register"}'> active</c:if>" href="/CLCProject/register">Register</a>
				</div>
			</c:when>
			
			<c:otherwise>
			
				<div class="navbar-nav">
					<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/editUser"}'> active</c:if>" 
					   href="/CLCProject/editUser?userName=${sessionScope.userName}">
						Profile
					</a>
					<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/bookList"}'> active</c:if>" 
					   href="/CLCProject/bookList">
						EBooks
					</a>
					<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/library"}'> active</c:if>" 
					   href="/CLCProject/library/library">
						Library
					</a>
					
					<c:if test="${sessionScope.admin}">
						<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/userList"}'> active</c:if>"
						   href="/CLCProject/userList">
							User List
						</a>	
					</c:if>
				</div>
				
				<div class="navbar-nav ml-auto">
					<a class="nav-item nav-link" href="/CLCProject/logout">Logout</a>
				</div>
		
			</c:otherwise>
	  	</c:choose>
	  	
  	</div>
</nav>