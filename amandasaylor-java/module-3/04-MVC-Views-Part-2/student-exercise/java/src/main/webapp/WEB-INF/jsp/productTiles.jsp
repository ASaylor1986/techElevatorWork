<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Tile View" />
</c:import>

<div id="masonry-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="#" />
	</c:import>

	<!-- Container for all of the Products -->
	<!-- The list of products is available using the `products` variable -->
	<div id="grid" class="main-content">

		<!-- The following HTML shows different examples of what HTML
		 could be rendered based on different rules. For purposes
		 of demonstration we've written it out so you can see it
		 when you load the page up. -->

		<!-- Standard Product -->
<div id="sorting-options">


		<!-- Container for all of the Products -->
		<!-- The list of products is available using the `products` variable -->
		<div id="grid">
		
		<c:forEach var="product" items="${products}">
			<c:choose>
				<c:when test="${product.topSeller}">
					<c:set var="tileClass" value="tile top-seller" />
				</c:when>
				<c:otherwise>
					<c:set var="tileClass" value="tile" />
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${product.remainingStock == 0}">
					<c:set var="isSoldOut" value="sold-out" />
				</c:when>
				<c:otherwise>
					<c:set var="isSoldOut" value="" />
				</c:otherwise>
			</c:choose>
			
			<div class="${tileClass} ${isSoldOut}">
				<c:if test="${product.remainingStock == 0}">
					<span class="banner sold-out">Sold Out</span>
				</c:if>
			
			
			<c:url var="itemDetails" value="/products/detail">
				<c:param name="id">${product.id}</c:param>
			</c:url>
			<a class="product-image" href="${itemDetails}">
				<img src=" <c:url value="/images/product-images/${product.imageName}"/>" />
			</a>
			
			<div class="details">
				<p class="name">${product.name}</p>
				
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
				
				<c:if test="${product.topSeller}">
					<br />
					<p class="product-alert"> Top Seller</p>
				</c:if>
				
				<c:if test="${product.remainingStock > 0 && product.remainingStock < 5}">
					<span class="product-alert">Only ${product.remainingStock} Left!</span>
				</c:if>
				
				<p class="price">
					<fmt:formatNumber type="currency"> ${product.price} </fmt:formatNumber>
				</p>
			</div>
			</div>
		</c:forEach>
		</div>
	</div>
</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />