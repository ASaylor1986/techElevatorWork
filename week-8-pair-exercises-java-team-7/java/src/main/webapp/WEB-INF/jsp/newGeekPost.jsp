<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

<h2>New Geek Post</h2>

<form:form class="form-inline" method="POST" action="newGeekPost" modelAttribute="newPost">
	<div class="formGroup">
		<label for="username">Username</label>
		<form:input  id="username"  path="username"/>
		<form:errors path="username" class="error"/>	
		<form:errors path="usernameMeetingLengthReq" class="error"/> 
	</div>
	<div class="formGroup">
		<label for="subject">Subject</label>
		<form:input type="text" name="subject" path="subject"/>
		<form:errors path="subject" class="error"/>
	</div>	
	<div class="formGroup">		
		<label for="message">Message</label>
		<form:input type="text" name="message" path="message"/>
		<form:errors path="message" class="error"/>
	</div>	
	
	<div class="formGroup">
		<input type="submit" value="Submit" />
	</div>





</form:form>



</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />