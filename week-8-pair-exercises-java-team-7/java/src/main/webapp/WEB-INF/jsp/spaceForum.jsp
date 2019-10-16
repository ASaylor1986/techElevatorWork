<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

<h2>Solar System Geek Forum</h2>


 <c:url var="clickableLink" value="/newGeekPost"> 
 </c:url>
  <a href ="${clickableLink}">Post A Message</a>
 


	<c:forEach var="post" items="${posts}">

<div class="forumPosts">

			<h3>${post.subject}</h3>
			<p>Posted by: ${post.username} On ${post.datePosted}</p>
			<p>${post.message}</p>
</div>
	</c:forEach>



</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />