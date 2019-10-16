<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

<h2>Shopping Cart</h2>

	<table id="shopping-cart-table">
	<tr >
	<th></th>
	<th style="color: black;">Name</th>
	<th style="color: black;">Price</th>
	<th style="color: black;">Qty.</th>
	<th style="color: black;">Total</th>
	</tr>
	
	<c:forEach var="thing" items="${cart}">
	<tr>
	<td></td>
 	<td>${thing.product.name}</td>
	<td><fmt:formatNumber type="currency" value="${thing.product.price}" pattern="#.##"/></td>
	<td>${thing.quantity}</td>
	<td><fmt:formatNumber type="currency" value="${thing.totalPricePerItem}" pattern="#.##"/></td>
 	
	</tr>
	</c:forEach>
	
	
<%-- 	<c:forEach var="thing" items"${cart}">
 --%>	
	
	
	
	
	</table>
	
	<c:forEach var="thing" items="${cart}">
	<c:set var="total" value="${total + thing.totalPricePerItem}"/>
	</c:forEach>
	
	<p>Grand Total: ${total} </p>
	
	<form method="POST">
	<button type="submit">Finalize Purchase</button>
	</form>



	</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />