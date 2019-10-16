<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">Register</c:param>
	<c:param name="activeNav" value="register"/>
</c:import>

<h2>New User Registration</h2>


		<c:url var="registerUrl" value="/register"/>
		<form:form id="register" action="${registerUrl}" method="POST" modelAttribute= "register">
			<div>
				<label for="firstName">First Name</label>
				<input class="form-control" id="firstName" name="firstName" type="text" placeholder="enter first name"/>	
				<form:errors path="firstName" class="error"/>			
			</div>
			<div>
				<label for="lastName">Last Name</label>
				<input class="form-control" id="lastName" name="lastName" type="text" placeholder="enter last name"/>	
				<form:errors path="lastName" class="error"/>			
			</div>
			<div>
				<label for="email">Email Address</label>
				<input class="form-control" id="email" name="email" type="text" placeholder="enter email"/>	
				<form:errors path="email" class="error"/>			
							
			</div>
			<div>
				<label for="email">Confirm Email</label>
				<input class="form-control" id="verifyEmail" placeholder="confirm email address"/>	
				<form:errors path="emailMatching" class="error"/>			
							
			</div>
			<div>
				<label for="password">Password</label>
				<input class="form-control" id="password" name="password" type="text" placeholder="*******"/>	
				<form:errors path="password" class="error"/>			
			</div>
			<div>
				<label for="confirmPassword">Confirm</label>
				<input class="form-control" id="confirmPassword" name="confirmPassword" type="text" placeholder="*******"/>	
				<form:errors path="passwordMatching" class="error"/>			
			</div>
			<div>
				<label for="birthday">Birthday</label>
				<input class="form-control" id="birthday" name="birthday" type="date"/>	
				<form:errors path="birthday" class="error"/>			
			</div>
			<div>
				<label for="numberOfTickets"># Of Tickets</label>
				<input class="form-control" id="numberOfTickets" name="numberOfTickets" type="number"/>	
				<form:errors path="numberOfTickets" class="error"/>			
			</div>
			<div>
				<input type="submit" value="Submit"/>
			</div>
		</form:form>



<c:import url="common/footer.jsp"/>