var bidHistory = angular.module('bidHistory-service', []);
bidHistory.factory('bidHistoryAPI', function($http) {

	var bidHistory = {};
	
	
	
	bidHistory.listBid = function(Data) {
		console.log(Data);
		return $http({
			method : 'GET',
			url : 'user/vendorBidHistory/'+Data,			
		});
	};
	
	return bidHistory;
});