PeopleApp
		.directive(
				'sorted',
				function() {
					return {
						restriction: 'A',
						scope : true,
						transclude : true,
						template : '<a ng-click="do_sort()" ng-transclude></a>'
								+ '<span ng-show="do_show(\'desc\')"><i class="icon-circle-arrow-down"></i></span>'
								+ '<span ng-show="do_show(\'asc\')"><i class="icon-circle-arrow-up"></i></span>',
						controller : function($scope, $element, $attrs) {
							$scope.sort_by = $attrs.sorted;

							$scope.do_sort = function() {
								$scope.sort($scope.sort_by);
							};
							$scope.do_show = function(asc) {
								return (asc != $scope.sort_direction)
										&& ($scope.sort_order == $scope.sort_by);
							};
						}
					};

				});

PeopleApp.directive('greet', function() {
	return {
		template : '<h2>Greetings from {{from}} to {{to}}</h2>',
		controller : function($scope, $element, $attrs) {
			$scope.from = $attrs.from;
			$scope.to = $attrs.greet;
		}
	};
});