<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Plane Shootout</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body class="container">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="page-header">
				<h1>Plane Shootout</h1>
			</div>

			<h2>Cities</h2>
			<table class="table">
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

			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">Add new city</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form"
						action="/smvc/planes/addCity?step=cityAttributes" method="POST">
						<div class="form-group">
							<label class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<input name="name" type="text"
									value="${sessionScope.cityForm.name}" />
								<button type="submit" class="btn">ADD CITY</button>
							</div>
						</div>
					</form>
				</div>
			</div>

			<h2>Planes</h2>
			<table class="table">
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

			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">Add new plane</h3>
				</div>
				<div class="panel-body">
					<form role="form" action="/smvc/planes/addPlane" method="POST" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input name="name" type="text" value="${planeForm.name}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Type</label>
						<div class="col-sm-10">
							<select name="type">
								<c:forEach var="pt" items="${planeTypes}">
									<option value="${pt}">${pt}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Healthpoint</label>
						<div class="col-sm-10">
							<input name="hp" type="text" value="${planeForm.hp}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"></label>
						<div class="col-sm-10">
							<button type="submit" class="btn">ADD PLANE</button>
						</div>
					</div>
					</form>
				</div>
			</div>
			<h2>Routes</h2>
			<table class="table">
				<tr>
					<td>Name</td>
					<td>Start</td>
					<td>Goal</td>
					<td>Via</td>
				</tr>
				
				<c:forEach var="r" items="${routes}">
					<tr>
						<td>${r.name}</td>
						<td>${r.start}</td>
						<td>${r.goal}</td>
						<td><c:forEach var="onRouteCity" items="${r.enRouteCities}">
								<span>${onRouteCity}</span>
							</c:forEach></td>
					</tr>
				</c:forEach>
			</table>

			<br>
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">Add new route</h3>
				</div>
				<div class="panel-body">
					<form role="form"
						action="/smvc/planes/addRoute?step=routeAttributes" method="POST" class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<input name="name" type="text" value="${sessionScope.routeForm.name}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Start</label>
							<div class="col-sm-10">
								<input name="start" type="text" value="${routeForm.start}" />
							</div>
						</div>
						 
						<div class="form-group">
							<label class="col-sm-2 control-label">Goal</label>
							<div class="col-sm-10">
								<input name="goal" type="text" value="${routeForm.goal}" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
								<button type="submit" class="btn">ADD ROUTE</button>
							</div>
						</div>
						
					</form>
				</div>
			</div>
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">Add new game</h3>
				</div>
				<div class="panel-body">
					<form role="form" action="/smvc/planes/addGame" method="POST" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">Planes</label>
						<div class="col-sm-10">
							<select name="plane">
								<c:forEach var="plane" items="${planes}">
									<option value="${plane.name}">${plane.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Routes</label>
						<div class="col-sm-10">
							<select name="route">
								<c:forEach var="route" items="${routes}">
									<option value="${route.name}">${route.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
								<button type="submit" class="btn">ADD GAME</button>
							</div>
						</div>
					
					</form>
				</div>
			</div>
		
		<div id="gameDiv"></div>
 		<button onclick="playGame()">PLAY GAME</button>
		</div>
		
		<div class="col-md-2"></div>
	</div>
</body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="/smvc/resources/js/planes.js"></script>
</html>
