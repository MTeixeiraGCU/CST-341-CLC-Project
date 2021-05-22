<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
	<div class="topnav">
		<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/'}">class="active"</c:if> href="">Home</a>
		<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/about'}">class="active"</c:if>href="about">About</a>
		<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/contact'}">class="active"</c:if>href="contact">Contact</a>
		
		<c:choose>
			<c:when test="${empty sessionScope.userName}">
				<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/login'}">class="active"</c:if>href="login">Login</a>
				<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/register'}">class="active"</c:if>href="register">Register</a>
			</c:when>
			<c:otherwise>
				<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/bookList'}">class="active"</c:if>href="bookList">eBooks</a>
				<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/editUser'}">class="active"</c:if>href="editUser?userName=${sessionScope.userName}">Profile</a>
				<a href="logout">Logout</a>
			</c:otherwise>
	  	</c:choose>
	  	
		<!--  Responsive login hooked to nav bar
		<div class="login-container">
	    	<form action="/action_page.php">
	    		<input type="text" placeholder="Username" name="username">
	      		<input type="text" placeholder="Password" name="psw">
	      		<button type="submit">Login</button>
	    	</form>
	  	</div>
	  	-->
	</div>
	
</div>