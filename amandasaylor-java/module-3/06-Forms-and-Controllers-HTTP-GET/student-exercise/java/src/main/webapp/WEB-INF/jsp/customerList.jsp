<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="common/header.jsp">
<c:param name="pageTitle">All Customers List</c:param>
<c:param name="activeNav" value="customers"/>
</c:import>


<form class="form-inline" method="GET" action="customerListResults">


	<label for="search"> Customer Name </label> 
	<input type="text" name="search" id="search"/>
	<br/>

	<label for="sort"> Choose a sort method: </label> 
	<select name="sort" id="sort">

		<option value="last_name"> Last Name </option>
		<option value="email"> Email </option>
		<option value="active"> Active </option>
	</select> <input class="formSubmitButton" id="sortButton" type="submit" value="Search" />
</form>


<table class="table">
	<tr> 
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Active</th>
	</tr>

	<c:forEach var = "customer" items="${customers}" varStatus="status">
	<tr>
		<td>${customer.firstName}</td> 
		<td>${customer.lastName }</td>
		<td>${customer.email} </td>
		<c:choose>
		<c:when test="${customer.active==true}">
			<td>Yes</td>
		</c:when>
		<c:when test="${customer.active==false}">
			<td>No</td>
		</c:when>
		</c:choose>
	</tr>
	</c:forEach>
</table>

<c:import url="common/footer.jsp"/>