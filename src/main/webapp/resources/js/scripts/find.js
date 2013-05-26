PeopleApp.factory('findByCountryLike', function($resource) {
	return $resource('/test/rest/people/search/findByCountryContaining:country', {
		country : '@country'
	}, {
		update : {
			method : 'GET'
		}
	});
});