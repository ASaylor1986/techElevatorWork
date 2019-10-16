<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<c:import url= "/WEB-INF/jsp/header.jsp">
<c:param name= "styleSheetLink" value="css/recipeDetails.css"/>
</c:import>


<div id="img">
<img id= "picture" src= "<c:url value = "img/recipe${recipe.recipeId}.jpg"/>"/>
</div>


<div id="infoSection">
	<h2>${recipe.name}</h2> 
	<p>${recipe.recipeType}</p> 
	<p>Cook Time ${recipe.cookTimeInMinutes} minutes</p>
	<p>${recipe.description}</p>
</div>



<div id= "ingredientList">
<h3>Ingredients</h3>
	<ul>
	<c:forEach var="ingredient" items="${recipe.ingredients}">
			<li>${ingredient.quantity} ${ingredient.name} </li>
	</c:forEach> 
	</ul>
</div>



<div id= "prepSteps">
<h3>Preparation</h3>
	<ol>
	<c:forEach var="direction" items="${recipe.preparationSteps}">
			<li>${direction} </li>
	</c:forEach> 
	</ol>
</div>











<c:import url= "/WEB-INF/jsp/footer.jsp"/>
