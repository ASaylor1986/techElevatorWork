<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">Register</c:param>
	<c:param name="activeNav" value="register"/>
</c:import>

<c:url var="registerUrl" value="/register"/>
<form:form action="${registerUrl}" method="POST" modelAttribute="user">
    <div class="form-group">
        <label for="username">Username</label>
        <form:input class="form-control" path="username" placeholder="Username"/>
        <form:errors path="username" class="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:password class="form-control" path="password"/>
        <form:errors path="password" class="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="confirmPassword">Confirm Password</label>
        <form:password class="form-control" path="confirmPassword"/>
        <form:errors path="passwordMatching" class="bg-danger"/>
    </div>
    <fieldset>
        <legend>Role</legend>
        <form:errors path="role" class="bg-danger"/>
        <div class="radio">
            <label>
                <form:radiobutton path="role" value="user" checked="checked"/>
                User
            </label>
        </div>
        <div class="radio">
            <label>
                <form:radiobutton path="role" value="admin"/>
                Administrator
            </label>
        </div>
        <div class="radio">
            <label>
                <form:radiobutton path="role" value="editor"/>
                Editor
            </label>
        </div>
    </fieldset>
    <button type="submit" class="btn btn-primary">Save User</button>
</form:form>

<c:import url="common/footer.jsp"/>