<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<h2>Solar System Geek Gift Shop</h2>
	
	
		<div id="product-detail-img" style="width:33%;">
		<img id="productPic" style="width:100%;" src= "<c:url value="img/${selectedProduct.imageName}"/>"/>
		</div>
	
	<div id="full-product-info" >
	<h1>${selectedProduct.name}</h1>
	<p id="price">${selectedProduct.price}</p>
	<p id="description">${selectedProduct.description}</p>
	
	<form id="purchase quantity" method="POST">
	<input type="number" name="quantity" placeholder="amount to buy">
	
	<button type="submit" name="submit">Add To Cart</button>
	</form>
	
	
	</div>
	
	
	
	
	</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
	