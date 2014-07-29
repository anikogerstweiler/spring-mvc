<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Plane Shootout - Route attributes</title>
</head>
<body>
	<h1>Plane Shootout - Route attributes</h1>
	
	<br>
	<form role="form" action="/smvc/planes/addRoute?step=routeAttributes" method="POST">
			<label>City</label> <br>
				<input name="enRouteCities" type="text" /> <br>
			<button type="submit">ADD CITY</button>
		</form>
	
	<br>
	
	<form role="form" action="/smvc/planes/addRoute?step=done" method="POST">
		<button type="submit">FINALIZE ROUTE</button>
	</form>
</body>
</html>