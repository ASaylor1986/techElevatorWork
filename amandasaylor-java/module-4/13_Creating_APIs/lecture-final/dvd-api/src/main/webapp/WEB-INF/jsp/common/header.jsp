<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${param.pageTitle}</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
    <style type="text/css">
        label {
            display: block;
        }

        .form-control {
            display: inline-block;
        }
    </style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item ${param.activeNav == 'actors'? 'active':''}">
	      	<c:url value="/actorForm" var="actorsUrl"/>
	        <a class="nav-link" href="${actorsUrl}">Actors</a>
	      </li>
	      <li class="nav-item ${param.activeNav == 'films'? 'active':''}">
	        <c:url value="/filmForm" var="filmsUrl"/>
	        <a class="nav-link" href="${filmsUrl}">Films</a>
	      </li>
	      <li class="nav-item ${param.activeNav == 'customers'? 'active':''}">
	        <c:url value="/customerForm" var="customersUrl"/>
	        <a class="nav-link" href="${customersUrl}">Customers</a>
	      </li>
	    </ul>
	  </div>
	</nav>

    <div class="container">