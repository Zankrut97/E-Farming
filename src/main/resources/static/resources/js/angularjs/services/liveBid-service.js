var liveBid = angular.module('liveBid-service', []);
liveBid.factory('liveBidAPI', function($http) {

	var liveBid = {};
	
	
	
	liveBid.listBid = function() {
	
		return $http({
			method : 'GET',
			url : 'user/liveBid/'			
		});
	};
	
	return liveBid;
});
