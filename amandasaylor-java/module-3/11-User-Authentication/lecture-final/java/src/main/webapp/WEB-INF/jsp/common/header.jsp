<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><c:out value="${param.pageTitle}"/></title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <c:url var="cssUrl" value="/css/site.css"/>
    <link rel="stylesheet" href="${cssUrl}" />
</head>
<body>    
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="collapse navbar-collapse justify-content-between" id="navbarNav">
	    <ul class="nav navbar-nav">
	      <li class="nav-item ${param.activeNav == 'home'? 'active':''}">
	      	<c:url value="/" var="homeUrl"/>
	        <a class="nav-link" href="${homeUrl}">Home</a>
	      </li>
	      <li class="nav-item ${param.activeNav == 'about'? 'active':''}">
	        <c:url value="/about" var="aboutUrl"/>
	        <a class="nav-link" href="${aboutUrl}">About</a>
	      </li>
	      <li class="nav-item ${param.activeNav == 'private'? 'active':''}">
	        <c:url value="/private" var="privateUrl"/>
	        <a class="nav-link" href="${privateUrl}">Private</a>
	      </li>
	    </ul>
	    <ul class="nav navbar-nav">
	      <c:if test="${empty appCurrentUser}">
	      	<li class="nav-item ${param.activeNav == 'login'? 'active':''}">
	       		<c:url value="/login" var="loginUrl"/>
	        	<a class="nav-link" href="${loginUrl}">Login</a>
	      	</li>
	      	<li class="nav-item ${param.activeNav == 'register'? 'active':''}">
	        	<c:url value="/register" var="registerUrl"/>
	         	<a class="nav-link" href="${registerUrl}">Register</a>
	        </li>
		  </c:if>
          <c:if test="${not empty appCurrentUser}">
			<li class="nav-item">
			    <span class="navbar-text mr-3"><c:out value="Hello, ${appCurrentUser.username}!" /></span>
			</li>
            <li class="nav-item">
                <c:url var="logoffUrl" value="/logoff"/>
            	<form action="${logoffUrl}" method="POST" class="navbar-form">
                   <button type="submit" class="btn btn-secondary">Log Off</button>
                </form>
            </li>
          </c:if>
	    </ul>
	  </div>
	</nav>

    <div class="container body-content">
    <c:if test="${not empty message}">
        <div class="message alert alert-danger" role="alert">
            <c:out value="${message}"/>
        </div>
    </c:if>