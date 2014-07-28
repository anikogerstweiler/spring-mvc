<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Plane Shootout - planes</title>
</head>
<body>
	<h1>Plane Shootout - planes</h1>
	
	<p>There are ${planeCount} planes on the list</p>
	
	<br>
	
	<table>
		<tr>
			<td>Name</td>
			<td>Type</td>
			<td>HP</td>
		</tr>
		
		<c:forEach var="p" items="${planes}">
			<tr>
				<td>${p.name}</td>
				<td>${p.type}</td>
				<td>${p.hp}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<form role="form" action="/smvc/planeShootout/planes/add" method="POST">
		<input name="name" type="text" value="${planeForm.name}" /> <br>
		<select name="type">
			<c:forEach var="pt" items="${planeTypes}">
				<option value="${pt}">${pt}</option>
			</c:forEach>
		</select>
		<br>
		<button type="submit">ADD</button>
	</form>
</body>
</html>
