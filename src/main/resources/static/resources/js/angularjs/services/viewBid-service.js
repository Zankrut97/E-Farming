var viewBid = angular.module('viewBid-service', []);
viewBid.factory('viewBidAPI', function($http) {

	var viewBid = {};
	
	
	
	viewBid.listBid = function(userId) {
	//console.log(userId);
		return $http({
			method : 'GET',
			url : 'user/bidding/'+ userId			
		});
	};
	
	return viewBid;
});
