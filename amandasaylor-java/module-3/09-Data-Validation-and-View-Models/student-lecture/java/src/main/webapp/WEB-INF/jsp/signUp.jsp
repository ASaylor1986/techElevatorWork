<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Awesome Mailing List</title>
		<style>
			.error {
				color:red;
			}
		</style>
	</head>
	<body>	
		<c:url var="mailingListSubmitUrl" value="/signUp"/>
		<form:form id="signUp" action="/validation-lecture/signUp" method="POST" modelAttribute= "signUp">
			<div>
				<label for="name">Name</label>
				<form:input id="name" name="name" type="text" path="name"/>	
				<form:errors path="name" class="error"/>			
			</div>
			<div>
				<label for="mailingAddress">Mailing Address</label>
				<form:input id="mailingAddress" name="mailingAddress" type="text" path="mailingAddress"/>	
				<form:errors path="mailingAddress" class="error"/>			
			</div>
			<div>
				<label for="email">Email Address</label>
				<form:input id="email" name="email" type="text" path="email"/>	
				<form:errors path="email" class="error"/>			
							
			</div>
			<div>
				<label for="email">Please Verify Your Email Address</label>
				<form:input id="verifyEmail" path="emailVerification"/>	
				<form:errors path="emailMatching" class="error"/>			
							
			</div>
			<div>
				<label for="phone">Phone Number (XXX)XXX-XXXX</label>
				<form:input id="phone" name="phone" type="text" path="phone"/>	
				<form:errors path="phone" class="error"/>			
			</div>
			<div>
				<label for="age">Age</label>
				<form:input id="age" name="age" type="text" path="age"/>	
				<form:errors path="age" class="error"/>			
			</div>
			<div>
				<label for="date">Date To Begin Subscription</label>
				<form:input id="date" name="date" type="date" path="subscribeDate"/>	
				<form:errors path="subscribeDate" class="error"/>			
			</div>
			<div>
				<input type="submit" value="Sign Me Up!"/>
			</div>
		</form:form>
	</body>
</html>