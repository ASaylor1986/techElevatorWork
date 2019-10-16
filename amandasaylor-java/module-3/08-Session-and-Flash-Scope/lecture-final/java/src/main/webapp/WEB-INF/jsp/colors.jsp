<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorite Color Picker</title>

	<style>
	
		body {
		
			background-color: ${backgroundColor == null? "white" : backgroundColor};
		
		}
	
	</style>
</head>
<body>

<form method="POST">
<input type="text" name="name" placeholder="Your Name"/>

<select name="colorChoice">
	<option value="thistle">Thistle</option>
	<option value="hotpink">Hot Pink</option>
	<option value="ghostwhite">Ghost White</option>
	<option value="saddlebrown">Saddle Brown</option>
	<option value="papayawhip">Papaya Whip</option>
</select>

<button type="submit">Make It So</button>

</form>

</body>
</html>