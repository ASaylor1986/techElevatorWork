<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<h2>Solar System Geek Gift Shop</h2>
	
	
	
	
	
	<c:forEach var="product" items="${products}">
	
	<div class="product-line">
	<c:url var="clickableLink" value = "/productDetails">
	<c:param name="productId">${product.id}</c:param>
	</c:url>
	<a href="${clickableLink}"> <img id="productPic" src= "<c:url value="img/${product.imageName}"/>"/> </a>
	
	<div class="product-info">
	<h3>${product.name}</h3>
	<p>${product.price}</p>
	</div>
	
	</div>
	</c:forEach>
	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
	