<!doctype html>
<html ng-app>
<head>
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/angular-strap.min.js"></script>
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap-datepicker.js"></script>
<script src="resources/js/script.js"></script>
<link href="resources/css/bootstrap-datepicker.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div ng-controller="Controller">
		<form novalidate class="simple-form">
			Name: <input type="text" ng-model="user.name" /><br /> E-mail: <input
				type="email" ng-model="user.email" /><br /> Gender: <input
				type="radio" ng-model="user.gender" value="male" />male <input
				type="radio" ng-model="user.gender" value="female" />female<br />
			<button ng-click="reset()">RESET</button>
			<button ng-click="update(user)">SAVE</button>
		</form>
		<pre>form = {{user | json}}</pre>
		<pre>master = {{master | json}}</pre>
	</div>
	<div class="control-group input-append date datepicker">
		<input type="text" ng-model="datepicker.date"
			data-date-format="dd/mm/yyyy" bs-datepicker>
		<button type="button" class="btn" data-toggle="datepicker">
			<i class="icon-calendar"></i>
		</button>
	</div>
	<div class="input-append date datepicker" data-date="12-02-2012"
		data-date-format="dd-mm-yyyy">
		<input size="16" type="text" value="12-02-2012" readonly><span
			class="add-on"><i class="icon-calendar"></i></span>
	</div>
	<!-- You can use the global $strapConfig to set defaults -->
	<script type="text/javascript">
		$('.datepicker').datepicker()
	</script>
</body>
</html>