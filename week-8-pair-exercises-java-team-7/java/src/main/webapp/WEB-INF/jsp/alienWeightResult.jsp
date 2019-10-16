<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<section id="calculatorResult">
	    <c:url value="/img/${fn:toLowerCase(param.planetName)}.jpg" var="planetSrc" />
	    <img src="${planetSrc}" alt="Image of ${param.planetName}" />
		<h2>
			If you are ${param.earthWeight} pounds on planet Earth, then you are 
			<fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${alienWeight}"/>
			${param.planetName} pounds. 
		</h2>
	</section>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />
