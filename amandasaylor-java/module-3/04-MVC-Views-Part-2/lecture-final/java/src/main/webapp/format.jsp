<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<c:set var="example" value="2.8"/>
	<div>
	This is a number: <fmt:formatNumber maxFractionDigits="2">1.2385293874293847</fmt:formatNumber>
	</div>
	<div>
	This is another number: <fmt:formatNumber maxFractionDigits="0" value="${example}"/>
	</div>
	<div>
	This is money: <fmt:formatNumber type="currency">${example}</fmt:formatNumber>
	</div>
	<fmt:formatNumber var="exampleMoney" type="currency" value="1"/>
	<div>${exampleMoney}</div>
</body>
</html>