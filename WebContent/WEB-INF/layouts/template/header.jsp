<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
	<div class="topnav">
		<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/'}">class="active"</c:if> href="">Home</a>
		<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/about'}">class="active"</c:if>href="/CLCProject/about">About</a>
		<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/contact'}">class="active"</c:if>href="/CLCProject/contact">Contact</a>
		
		<c:choose>
			<c:when test="${empty sessionScope.userName}">
				<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/login'}">class="active"</c:if>href="/CLCProject/login">Login</a>
				<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/register'}">class="active"</c:if>href="/CLCProject/register">Register</a>
			</c:when>
			<c:otherwise>
				<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/bookList'}">class="active"</c:if>href="/CLCProject/bookList">eBooks</a>
				<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/library'}">class="active"</c:if>href="/CLCProject/library/library">Library</a>
				<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/editUser'}">class="active"</c:if>href="/CLCProject/editUser?userName=${sessionScope.userName}">Profile</a>
				<c:if test="${sessionScope.admin}">
				<a <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/CLCProject/userList'}">class="active"</c:if>href="/CLCProject/userList">User List</a>	
				</c:if>
				<a href="logout">Logout</a>
			</c:otherwise>
	  	</c:choose>
	</div>
	
</div>