<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<body>


	<header>
		<h1> Welcome to The Party...</h1>
		<h3>the Squirrel Cigar Party!!!!!</h3>

	</header>

	<div class="stars">	

	</div>
	<div class="twinkling"></div>
	<div class="clouds"></div>
<div id="main-content">
	<div id="attentionGrabbers">
		<div id="tagLines">	
			<p>#1 request in Oprah's book club!</p><br>
			<p>This book has been on the New York Times Best Seller list for 100 yrs!</p><br>
			<p>Teach your squirrels to love nicotine! Just like God intended!... 'Merica!</p><br>
			<p>A great Christmas gift for anyone! Even toddlers!</p><br><br>
			<p>************************************************</p><br><br>
			<p style="font-style: italic">Take your party from NOT to HOT for only $19.99!</p>

		</div>
		<div id="bookPic">
			<img src= "<c:url value="/img/forDummies.png"/>"/>
		</div>
	</div>	
	<div id="reviews">
		<h3 id="reviewHeadline"> Squirrel Cigar Party Reviews!</h3>
		<div id="eachReview">
		<c:forEach var="review" items="${reviews}">
			<div id="forumPosts" class="forumPosts">
				<h3 id="reviewTitle" >${review.title}</h3>
				<p>How many stars would I give this book? ${review.rating}!</p>
				<p>${review.text}</p>
				<p>Posted by: ${review.username}</p> 

				<p>Posted on: ${review.dateSubmitted}" </p>
			</div>
		</c:forEach>
		</div>
		<div id="newPost">
		<c:url var="clickableLink" value="/newSquirrelPartyReview"></c:url>
		<a href ="${clickableLink}">Post a new review about our AWESOME book!</a>
		</div>	
	</div>

	
</div>

</body>
</html>