<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Plane Shootout - City attributes</title>
</head>
<body>
	<h1>Plane Shootout - CIty attributes</h1>
	
	<br>
	<form role="form" action="/smvc/planes/addCity?step=cityAttributes" method="POST">
		<label>Type</label> <br>
		<select name="type">
			<c:forEach var="pt" items="${planeTypes}">
				<option value="${pt}">${pt}</option>
			</c:forEach>
		</select><br>
		<label>Likelihood</label> <br>
		<input name="likelihood" type="number" /> <br>
		<label>FirePower</label> <br>
		<input name="firePower" type="number" /> <br>
		<br>
		<button type="submit">SET PLANE TYPE</button>
	</form>
	
	<br>
	
	<form role="form" action="/smvc/planes/addCity?step=done" method="POST">
		<button type="submit">FINALIZE CITY</button>
	</form>
</body>
</html>