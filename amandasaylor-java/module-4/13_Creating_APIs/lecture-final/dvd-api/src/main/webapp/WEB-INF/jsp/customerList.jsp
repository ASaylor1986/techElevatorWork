<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">All Customers List</c:param>
	<c:param name="activeNav" value="customers"/>
</c:import>

<form method="GET" class="form-inline" action="customerSearch">
    <input name="search" type="text" placeholder="Search" class="form-control"/>
    <div class="form-group">
        <label for="sortBy">Sort: </label>
        <select name="sortBy" class="form-control">
            <option value="last_name">Last Name</option>
            <option value="email">Email</option>
            <option value="active">Active</option>
        </select>
    </div>
    <input name="submit" value="Search" type="submit" class="btn btn-primary" />
</form>
<table class="table">
<tr>
<th>Name</th>
<th>Email</th>
<th>Active</th>
</tr>
<c:forEach items="${customers}" var="cust">
<tr>
<td><c:out value="${cust.firstName}"/> <c:out value="${cust.lastName}"/></td>
<td><c:out value="${cust.email}"/></td>
<td><c:out value="${cust.active ? 'Yes' : 'No'}"/></td>
</tr>
</c:forEach>
</table>






<c:import url="common/footer.jsp"/>