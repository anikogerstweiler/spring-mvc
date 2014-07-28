<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Plane Shootout</title>
</head>
<body>
	<h1>Plane Shootout</h1>
	
	<h2>Cities</h2>
	<table border = "3">
		<tr>
			<td>Name</td>
			<td>Likelihood</td>
			<td>FirePower</td>
		</tr>
		<c:forEach var="c" items="${cities}">
			<tr>
				<td>${c.name}</td>
				<td>${c.likelihoods}</td>
				<td>${c.firePowers}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<fieldset>
		<legend>Add new city</legend>
		<label>Name</label> <br>
		<form role="form" action="/smvc/planes/addCity?step=cityAttributes" method="POST">
     		<input name="name" type="text" value="${sessionScope.cityForm.name}" /> <br>
     		<br>
     		<button type="submit">ADD CITY</button>
    	</form>
	</fieldset>
	
	<h2>Planes</h2>
	<table border = "3">
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
	<fieldset>
		<legend>Add new plane</legend>
		<form role="form" action="/smvc/planes/addPlane" method="POST">
			<label>Name</label> <br>
			<input name="name" type="text" value="${planeForm.name}" /> <br>
			<label>Type</label> <br>
			<select name="type">
				<c:forEach var="pt" items="${planeTypes}">
					<option value="${pt}">${pt}</option>
				</c:forEach>
			</select>
			<br>
			<label>HealthPoint</label> <br>
			<input name="hp" type="number" value="${planeForm.hp}" /> <br>
			<button type="submit">ADD</button>
		</form>
	</fieldset>
	
	<h2>Routes</h2>
	<table border = "3">
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
	
	<br>
	<fieldset>
		<legend>Add new route</legend>
		<label>Name</label> <br>
		<form role="form" action="/smvc/planes/addRoute?step=routeAttributes" method="POST">
     		<input name="name" type="text" value="${sessionScope.routeForm.name}" /> <br>
     		<br>
     		<button type="submit">ADD ROUTE</button>
    	</form>
	</fieldset>
	
</body>
</html>
