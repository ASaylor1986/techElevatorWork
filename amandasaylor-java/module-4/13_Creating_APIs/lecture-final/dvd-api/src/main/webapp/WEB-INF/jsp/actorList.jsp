<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">All Actors List</c:param>
	<c:param name="activeNav" value="actors"/>
</c:import>

<form class="form-inline" method="GET" action="actorSearch">
    <input class="form-control" name="search" placeholder="Search">
    <input class="btn btn-primary" name="submit" value="Submit" type="submit"/>
</form>
<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actors}" var="actor">
<tr>
<td><c:out value="${actor.firstName}"/> <c:out value="${actor.lastName}"/></td>
</tr>
</c:forEach>
</table>

<c:import url="common/footer.jsp"/>