<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Preferences</title>
</head>
<body>

<div class="container">

<fieldset>
<legend>I would not like to hear music from these genres:</legend>
<form action="/preferences" > 

<input type="checkbox" name="genres" value="Rock">Rock</br>
<input type="checkbox" name="genres" value="Country">Country</br>
<input type="checkbox" name="genres" value="Folk">Folk</br>
<input type="checkbox" name="genres" value="Metal">Metal</br>
<input type="checkbox" name="genres" value="Trance">Electronic/Trance</br>
<input type="checkbox" name="genres" value="Latin">Latin</br>
<input type="checkbox" name="genres" value="Opera">Opera</br>
<input type="checkbox" name="genres" value="Rap">Rap</br>
<input type="checkbox" name="genres" value="Classical">Classical</br>
<input type="checkbox" name="genres" value="Jazz">Jazz</br>
<input type="submit" value="Submit">

 </form>
</fieldset>



</div>

</body>
</html>