var allBid = angular.module('allBid-service', []);
allBid.factory('allBidAPI', function($http) {

	var allBid = {};
	
	
	
	allBid.listBid = function() {
	
		return $http({
			method : 'GET',
			url : 'user/allBid/'			
		});
	};
	
	return allBid;
});