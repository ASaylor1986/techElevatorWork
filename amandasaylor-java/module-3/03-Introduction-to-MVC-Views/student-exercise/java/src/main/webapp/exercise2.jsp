<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 2 - Fibonacci 25</title>
		<style>
			li {
				list-style-type: none;
			}
		</style>
	</head>
	<body>
		<h1>Exercise 2 - Fibonacci 25</h1>
		<ul>
		
			<c:set var="fibNum" value="${param.fibNum}">
			</c:set>
				<c:if test="${empty fibNum}">
					<c:set var="fibNum" value="25">
					</c:set>
				</c:if>
			<c:set var="startingNum" value="0" />
			<c:set var="nextNum" value="1" />
			
			<c:forEach begin="1" end="${fibNum}" var="index">
				<c:set var="currentSum" value="${startingNum + nextNum}" />
				<li>${currentSum}</li>
				<c:set var="startingNum" value="${nextNum}" />
				<c:set var="nextNum" value="${currentSum}" />
			</c:forEach>
			<%--
				Add a list item (i.e. <li>) for each of the first 25 numbers in the Fibonacci sequence
				See exercise2-fibonacci.png for example output
			 --%>
		</ul>
	</body>
</html>