var PeopleApp = angular.module("PeopleApp", [ "ngResource" ]).config(
		function($routeProvider) {
			$routeProvider.when("/", {
				controller : ListCtrl,
				templateUrl : 'home/list'
			}).otherwise({
				redirectTo : '/'
			});
		});
PeopleApp.factory('People', function($resource) {
	return $resource('/test/rest/people/:id', {
		id : '@id'
	}, {
		update : {
			method : 'GET'
		}
	});
});

var ListCtrl = function($scope, $location, People) {
	$scope.search = function() {
		var sortBy = $scope.sort_order;
		People.get({
			sort : sortBy,
			order : $scope.sort_direction,
			limit : $scope.limit,
			page : $scope.page
		}, function(data) {
			$scope.more = !(data.page.number === data.page.totalPages);
			$scope.less = !(data.page.number === 1);
			$scope.peoples = data;
		});
	};

	$scope.sort = function(col) {
		if ($scope.sort_direction === "desc") {
			$scope.sort_direction = "asc";
		} else if ($scope.sort_direction === "asc") {
			$scope.sort_direction = "desc";
		}
		$scope.sort_order = col;
		$scope.search();
	};

	$scope.show_next = function() {
		if ($scope.more) {
			$scope.page++;
			$scope.search();
		}
	};

	$scope.show_previous = function() {
		if ($scope.less) {
			$scope.page--;
			$scope.search();
		}
	};

	$scope.has_more = function() {
		if ($scope.more) {
			return "acitve";
		} else {
			return "disabled";
		}
	};

	$scope.has_less = function() {
		if ($scope.less) {
			return "acitve";
		} else {
			return "disabled";
		}
	};

	$scope.reset= function(){

		$scope.limit = 20;
		$scope.page = 1;
		$scope.peoples = [];
		$scope.more = true;
		$scope.less = false;
		$scope.search();
	};
	
	$scope.sort_order = "name";
	$scope.sort_direction = "asc";

	$scope.reset();
};
