	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url= "/WEB-INF/jsp/header.jsp">

<c:param name= "styleSheetLink" value="css/tableSite.css"/>
</c:import>
    
	<table id="recipes">
    	<tr id= "headline">
			<th></th>
			<th></th>
			<th>Recipes</th>
			<th></th>
		</tr>
		<tr>
			<td></td>
			<td class= "pics"><img id= "foodPic" src = "<c:url value = "img/recipe0.jpg"/>"/></td>
			<td class= "pics"><img id= "foodPic" src = "<c:url value = "img/recipe1.jpg"/>"/></td>
			<td class= "pics"><img id= "foodPic" src = "<c:url value = "img/recipe2.jpg"/>"/></td>	
		</tr>
		<tr id= "table-contents">
			<td id= "title">Name</td>
			<td class="grey">${recipes[0].name}</td>
			<td class="grey">${recipes[1].name}</td>
			<td class="grey">${recipes[2].name}</td>
		</tr>
		<tr id= "table-contents" class = "type">
			<td id= "title">Type</td>
			<td>${recipes[0].recipeType}</td>
			<td>${recipes[1].recipeType}</td>
			<td>${recipes[2].recipeType}</td>
		</tr>
		<tr id= "table-contents">
			<td id= "title">Cook Time</td>
			<td class="grey">${recipes[0].cookTimeInMinutes}</td>
			<td class="grey">${recipes[1].cookTimeInMinutes}</td>
			<td class="grey">${recipes[2].cookTimeInMinutes}</td>
		</tr>
		<tr id= "table-contents">
			<td id= "title">Ingredients</td>
			<td><p>${recipes[0].ingredients.size()} ingredients</p></td>
			<td><p>${recipes[1].ingredients.size()} ingredients</p></td>
			<td><p>${recipes[2].ingredients.size()} ingredients</p></td>
		</tr>
		<tr>
			<td id= "title">Rating</td>
			<td class="grey"><img id= "starRating" src= "<c:url value = "img/3-star.png"/>"/></td>
			<td class="grey"><img id= "starRating" src= "<c:url value = "img/4-star.png"/>"/></td>
			<td class="grey"><img id= "starRating" src= "<c:url value = "img/2-star.png"/>"/></td>
		</tr>

    </table> 

<c:import url= "/WEB-INF/jsp/footer.jsp"/>
