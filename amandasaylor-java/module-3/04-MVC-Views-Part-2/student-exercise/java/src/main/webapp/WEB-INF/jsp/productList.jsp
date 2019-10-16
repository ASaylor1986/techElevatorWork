<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product List View" />
</c:import>

<div id="card-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="#" />
	</c:import>

	<div class="main-content">

		<!-- Container for Sorting Choices
         
         Each link should take the user to this current page and use any combination of the following
         querystring parameters to sort the page:
            - sortOrder (string) - PriceLowToHigh,PriceHighToLow,RatingHighToLow
    	-->
		<div id="sorting-options">
			<h3>Sort By</h3>
			<ul>
				<li>
					<c:url var="sorting" value="${baseRoute}?">
						<c:param name="sortOrder">priceLowToHigh</c:param>
					</c:url>
					<a href="${sorting}">Price - Low to High</a>
				</li>
				<li>
					<c:url var="sorting" value="${baseRoute}?">
						<c:param name="sortOrder">priceHighToLow</c:param>
					</c:url>
					<a href="${sorting}">Price - High to Low</a>
				</li>
				<li>
					<c:url var="sorting" value="${baseRoute}?">
						<c:param name="sortOrder">ratingHighToLow</c:param>
					</c:url>
					<a href="${sorting}">Rating - High to Low</a>
				</li>
			</ul>
		</div>

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

<c:import url="/WEB-INF/jsp/common/footer.jsp" />