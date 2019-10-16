<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Container for Filter Choices
        Each link should take the user to this current page and use any combination of the following
        querystring parameters to filter the page:
        - maxPrice (number)
        - minPrice (number)
        - minRating (number)
        - category (string) - Home, Apparel, Jewelry, Garden

        NOTE: A parameter is passed to this view that is called `baseRoute`. `baseRoute`
        refers to the page that the filters should be associated with. For instance, if you are on the products
        page, the value of the `baseRoute` should be the route for products and on the tiles page, should be the
        route for tiles.
        -->
<div id="filter-options">
	<h3>Refine By</h3>
	<ul>
		<li>
			<c:url var="under25Href" value="${baseRoute}">
				<c:param name="maxPrice" value="25">25</c:param>
			</c:url>
			<a href="${under25Href}">Under $25</a>
		</li>
		<li>
			<c:url var="from25to50" value="${baseRoute}">
				<c:param name="minPrice" value="25">25</c:param>
				<c:param name="maxPrice" value="50">50</c:param>
			</c:url>
			<a href="${from25to50}">$25 to $50</a>
		</li>
		<li>
			<c:url var="over50" value="${baseRoute}">
				<c:param name="minPrice" value="50">50</c:param>
			</c:url>
			<a href="${over50}">$50 &amp; Above</a>
		</li>
	</ul>
	<p>Avg. Review</p>
	<ul>
		<li>
			<c:url var="fourAndUp" value="${baseRoute}">
				<c:param name="minRating">4</c:param>
			</c:url>
			<a class="rating" href="${fourAndUp}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<c:url var="threeAndUp" value="${baseRoute}">
				<c:param name="minRating">3</c:param>
			</c:url>
			<a class="rating" href="${threeAndUp}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<c:url var="twoAndUp" value="${baseRoute}">
				<c:param name="minRating">4</c:param>
			</c:url>
			<a class="rating" href="${twoAndUp}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<c:url var="oneAndUp" value="${baseRoute}">
				<c:param name="minRating">4</c:param>
			</c:url>
			<a class="rating" href="${oneAndUp}">
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
	</ul>
	<p>Category</p>
	<ul>
		<li>
			<c:url var="home" value="${baseRoute}">
				<c:param name="category">Home</c:param>
			</c:url>
			<a href="${home}">Home</a>
		</li>
		<li>
			<c:url var="apparel" value="${baseRoute}">
				<c:param name="category">Apparel</c:param>
			</c:url>
			<a href="${apparel}">Apparel</a>
		</li>
		<li>
			<c:url var="jewelry" value="${baseRoute}">
				<c:param name="category">Jewelry</c:param>
			</c:url>
			<a href="${jewelry}">Jewelry</a>
		</li>
		<li>
			<c:url var="garden" value="${baseRoute}">
				<c:param name="category">Garden</c:param>
			</c:url>
			<a href="${garden}">Garden</a>
		</li>
	</ul>
</div>
