<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">About</c:param>
	<c:param name="activeNav" value="about"/>
</c:import>
<h1>About this application</h1>

<p>This application is a demonstration of an authentication program that you can use to base your projects off of. Take a look at the AccountController to see how to restrict access to pages using a logged in user and a user's role.</p>

<c:import url="common/footer.jsp"/>