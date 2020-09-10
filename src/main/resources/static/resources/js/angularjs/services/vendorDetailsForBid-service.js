var vendorDetailsForBidService = angular.module('vendorDetailsForBid-service', []);
vendorDetailsForBidService.factory('vendorDetailsForBidAPI', function($http) {

	var viewDetails = {};
	
	
	
	viewDetails.listBid = function(userId) {
	//console.log(userId);
		return $http({
			method : 'GET',
			url : 'user/vendorDetailsForBid/'+ userId			
		});
	};
	
	return viewDetails;
});
