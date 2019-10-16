<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<body style= "background-color: #FF00FF">
	<header>
		<h3>We can't wait to read your review!</h3>

	</header>

<div id="main-content">


<form id="reviewForm" class="form-inline" method="POST" action="newSquirrelPartyReview">
	<div class="formGroup">
		<label for="username">Username</label>
		<input type="text" name="username" style="width: 400px"/>
	</div>
	<div class="formGroup">
		<label for="title">Review Title</label>
		<input type="text" name="title" style="width: 400px"/>
	</div>	
	<div class="formGroup">		
		<label for="text">Review Message</label>
		<input type="text" name="text" style="width: 400px"/>
	</div>	
	<div class="formGroup">		
		<label for="rating">Review Rating</label>
		<input type="text" name="rating" style="width: 400px"/>
	</div>	
	
	<div class="formGroup">
		<input type="submit" value="Submit" />
	</div>

</form>

</div>

</body>
</html>