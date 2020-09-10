var farmerRequestList = angular.module('farmerRequestList-service', []);
farmerRequestList.factory('farmerListAPI', function($http) {

	var farmerRequestList = {};
	
	
	
	farmerRequestList.requestList = function() {
	
		return $http({
			method : 'GET',
			url : 'user/requestFarmerDetailList/'			
		});
	};
	
	return farmerRequestList;
});
