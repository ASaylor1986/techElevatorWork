<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url= "/WEB-INF/jsp/header.jsp">
<c:param name= "styleSheetLink" value="css/site.css"/>
</c:import>


<h1 id="recipe-header"> Recipes</h1>
    
<div id= "recipe-cards">
	<c:forEach var="recipe" items="${recipes}">
		<div>
		   <c:url var ="clickableLink" value = "/recipeDetails">
		   <c:param name = "recipeId">${recipe.recipeId}</c:param>
		   </c:url>
	    	<a href = "${clickableLink}"><img id= "picture" src= "<c:url value = "img/recipe${recipe.recipeId}.jpg"/>"/></a>
	    	<h2> ${recipe.name}</h2>
		</div>
	</c:forEach> 
</div> 
 	
 	
 <footer>
<%--  	<c:forEach var="recipe" items="${recipes}">
		<div>
			<img id= "starRating" src= "<c:url value = "img/3-star.png"/>"/>
			<p>${recipes[0].ingredients.size()} ingredients</p>
		</div>
	</c:forEach>  --%>
 	
 	
	<div id="card1">
	 		<img id= "starRating" src= "<c:url value = "img/3-star.png"/>"/>
			<p>${recipes[0].ingredients.size()} ingredients</p>
 		</div>
 		
 		<div id="card2">
 		 	<img id= "starRating" src= "<c:url value = "img/4-star.png"/>"/>
 		 	<p>${recipes[1].ingredients.size()} ingredients</p>
 		</div>
 		
 		<div id="card3">
 		 	<img id= "starRating" src= "<c:url value = "img/2-star.png"/>"/>
 		 	<p>${recipes[2].ingredients.size()} ingredients</p>
 		</div> 
 </footer>


       <!-- Use the request attribute "recipes" (List<Recipe>) -->

<c:import url= "/WEB-INF/jsp/footer.jsp"/>
