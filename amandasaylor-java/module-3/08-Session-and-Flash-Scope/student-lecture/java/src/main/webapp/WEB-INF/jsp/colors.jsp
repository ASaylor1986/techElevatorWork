<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorite Color Picker</title>

<style>
	body{
	background-color: ${backgroundColor == null? white : backgroundColor}
	}
</style>
</head>
<body>

<form method="POST">
<input type="text" name="name" placeholder="Your Name"/>
<select name="colorChoice">
	<option value = "hotPink"> Hot Pink </option>
	<option value = "yellow"> Yellow </option>
	<option value = "violet"> Violet</option>
	<option value = "darkSlateBlue"> Dark Slate Blue </option>
	<option value = "green"> Green</option>
	<option value = "cyan"> Cyan </option>
	<option value = "skyBlue"> SkyBlue </option>	
</select>

<button type="submit">Make It So</button>
</form>
</body>
</html>