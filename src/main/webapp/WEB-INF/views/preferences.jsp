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
<form action="/preferences"> 

	<input type="checkbox" name="genres" value="Rock" <c:if test="${imploded.contains('Rock')}">checked</c:if>><label for="Rock">Rock</label><br>
	<input type="checkbox" name="genres" value="Country" <c:if test="${imploded.contains('Country')}">checked</c:if>><label for="Country">Country</label><br>
	<input type="checkbox" name="genres" value="Folk" <c:if test="${imploded.contains('Folk')}">checked</c:if>><label for="Folk">Folk</label><br>
	<input type="checkbox" name="genres" value="Metal" <c:if test="${imploded.contains('Metal')}">checked</c:if>><label for="Metal">Metal</label><br>
	<input type="checkbox" name="genres" value="Trance" <c:if test="${imploded.contains('Trance')}">checked</c:if>><label for="Trance">Trance</label><br>
	<input type="checkbox" name="genres" value="Latin" <c:if test="${imploded.contains('Latin')}">checked</c:if>><label for="Latin">Latin</label><br>
	<input type="checkbox" name="genres" value="Opera" <c:if test="${imploded.contains('Opera')}">checked</c:if>><label for="Opera">Opera</label><br>
	<input type="checkbox" name="genres" value="Rap" <c:if test="${imploded.contains('Rap')}">checked</c:if>><label for="Rap">Rap</label><br>
	<input type="checkbox" name="genres" value="Classical" <c:if test="${imploded.contains('Classical')}">checked</c:if>><label for="Classical">Classical</label><br>
	<input type="checkbox" name="genres" value="Jazz" <c:if test="${imploded.contains('Jazz')}">checked</c:if>><label for="Jazz">Jazz</label><br>

<input type="submit" value="Submit" data-dismiss="alert">
<%--//FIXME stretch goal. reset all <button type="reset" value="Reset" name="${ genres = null }">Reset</button> --%>



</form>
</fieldset>

	</div>

</body>

</html>