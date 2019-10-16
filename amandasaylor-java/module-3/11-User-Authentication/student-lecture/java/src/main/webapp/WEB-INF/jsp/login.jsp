<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">Login</c:param>
	<c:param name="activeNav" value="login"/>
</c:import>

<c:url var="loginUrl" value="/login"/>
<form action="${loginUrl}" method="POST">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form>

<c:import url="common/footer.jsp"/>