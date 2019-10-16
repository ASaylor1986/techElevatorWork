<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">Private</c:param>
	<c:param name="activeNav" value="private"/>
</c:import>

<h1>This page is only allowed to be seen by logged in users!</h1>

<p>You can see it because your role is: ${appCurrentUser.role}</p>

<c:import url="common/footer.jsp"/>