<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Plane Shootout</title>
</head>
<body>
	<h1>Plane Shootout</h1>
	
	<br>
	<table>
		<tr>
			<td>	
				<h2>Cities</h2>
				<table>
					<tr>
						<td>Name</td>
					</tr>
					<c:forEach var="c" items="${cities}">
						<tr>
							<td>${c.name}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
			<td>	
				<h2>Planes</h2>
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
			</td>
			<td>	
				<h2>Routes</h2>
				<table>
					<tr>
						<td>Name</td>
						<td>Start</td>
						<td>Goal</td>
					</tr>
					<c:forEach var="r" items="${routes}">
						<tr>
							<td>${r.name}</td>
							<td>${r.start}</td>
							<td>${r.goal}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	
	<br>
	
	<!--
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
	-->
</body>
</html>
