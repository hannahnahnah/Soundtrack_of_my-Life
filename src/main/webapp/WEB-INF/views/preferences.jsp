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

<input type="checkbox" name="genre[]" value="Rock">Rock</br>
<input type="checkbox" name="genre[]" value="Country">Country</br>
<input type="checkbox" name="genre[]" value="Folk">Folk</br>
<input type="checkbox" name="genre[]" value="Metal">Metal</br>
<input type="checkbox" name="genre[]" value="Trance">Electronic/Trance</br>
<input type="checkbox" name="genre[]" value="Latin">Latin</br>
<input type="checkbox" name="genre[]" value="Opera">Opera</br>
<input type="checkbox" name="genre[]" value="Rap">Rap</br>
<input type="checkbox" name="genre[]" value="Classical">Classical</br>
<input type="checkbox" name="genre[]" value="Jazz">Jazz</br>
<input type="submit" value="Submit">

 </form>
</fieldset>



</div>

</body>
</html>