<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<div class="container">
		<h1 class="text-primary">
		</h1>
		<table class="table">
		
			<thead class="text-success">
				<tr>
					<th>City Name</th>
					<th>Temperature</th>
					<th>Condition</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
						<td>${name}</td>
						<td>${temp}&#8457</td>
						<td>${mainCondition}</td>
						<td>${description}</td>
					</tr>
				
			</tbody>
		</table>
	</div>
</body>
</html>