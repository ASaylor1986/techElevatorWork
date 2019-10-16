<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="common/header.jsp">

	<c:param name="pageTitle">Login</c:param>
	<c:param name="activeNav" value="login"/>
</c:import>

<h2>Login</h2>

		<c:url var="loginUrl" value="/login"/>
		<form:form action="${loginUrl}" method="POST" modelAttribute= "login">

			<div>
		        <label for="email">Email</label>
		        <input type="text" class="form-control" id="email" name="email" placeholder="enter email">
				<form:errors path="email" class="error"/>								
			</div>
			<div>
		        <label for="password">Password</label>
		        <input type="password" class="form-control" id="password" name="password" placeholder="enter password">
				<form:errors path="password" class="error"/>								
			</div>
			<div>
				<input type="submit" value="Submit"/>
			</div>
		</form:form>


<c:import url="common/footer.jsp"/>