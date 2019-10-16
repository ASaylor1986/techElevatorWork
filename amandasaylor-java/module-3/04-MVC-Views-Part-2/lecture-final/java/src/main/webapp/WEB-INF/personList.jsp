<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Person List Example</title>
		
		<style>
			.minor {
				color: red;
			}
		</style>
	</head>
	<body>
		
		<table>
		
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Adult?</th>
		</tr>		
		<c:forEach var="person" items="${personList}">
			<tr class='${person.adult? "" : "minor" }'>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.age}</td>
				<td>${person.adult? "yes" : "no"}</td>
			</tr>
		</c:forEach>
		</table>
				
	</body>
</html>