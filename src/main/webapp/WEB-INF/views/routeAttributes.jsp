<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Plane Shootout - Route attributes</title>
</head>
<body>
	<h1>Plane Shootout - Route attributes</h1>
	
	<br>
	<form role="form" action="/smvc/planes/addRoute?step=routeAttributes" method="POST">
			<label>Name</label> <br>
			<input name="name" type="text" value="${routeForm.name}" /> <br>
			<label>Start</label> <br>
			<input name="start" type="text" value="${routeForm.start}" /> <br>
			<label>Goal</label> <br>
			<input name="goal" type="text" value="${routeForm.goal}" /> <br>
			<button type="submit">ADD ROUTE</button>
		</form>
	
	<br>
	
	<form role="form" action="/smvc/planes/addRoute?step=done" method="POST">
		<button type="submit">FINALIZE ROUTE</button>
	</form>
</body>
</html>