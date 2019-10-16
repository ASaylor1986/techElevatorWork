<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Details" />
</c:import>

<!-- Container for the Product -->
<!-- The current product is available using the `product` variable -->
<div id="product-detail">
	<img src="<c:url value="/images/product-images/${product.imageName}" />" />
	<div class="product-description">
		<h3>${product.name}</h3>
		
			<div class="rating">
				<fmt:formatNumber var="rating" maxFractionDigits="0"
						value="${product.averageRating}"/>
				<c:forEach var="star" begin="1" end="${rating}">
					<span class="filled">&#9734;</span> 
				</c:forEach>
				<c:forEach var="star" begin="1" end="${5-rating}">
					<span>&#9734;</span> 
				</c:forEach>
			</div>
			
			<c:if test="${product.remainingStock > 0 && product.remainingStock < 5}">
				<p class="alert-remaining"> BUY NOW! Only ${product.remainingStock} left!</p>
			</c:if>
			
			<p class="description">${product.description}</p>
			
			<p class="price">
				<fmt:formatNumber type="currency"> ${product.price} </fmt:formatNumber>
			</p>
			
			<c:choose>
				<c:when test="${product.remainingStock > 0}">
					<button class="action"> Add to Cart</button>
				</c:when>
				<c:otherwise>
					<button class="disabled"> Sold Out!</button>
				</c:otherwise>
			</c:choose>


	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />