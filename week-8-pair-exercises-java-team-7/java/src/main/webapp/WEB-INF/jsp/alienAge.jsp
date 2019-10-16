<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<h2>Alien Age Calculator</h2>

	<c:url value="/alienAgeResult" var="alienAgeResultUrl" />
	<form action="${alienAgeResultUrl}">
		<div>
			<label for="planetName">Choose a Planet</label>
			<select name="planetName">
				<c:forEach var="planet" items="${planets}">
					<option value="${planet.name}">${planet.name}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label for="earthAge">Enter Your Earth Age</label>
			<input type="text" name="earthAge" />
		</div>
		<button type="submit">Calculate Age</button>
	</form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
