var vendorRequestList = angular.module('vendorRequestList-service', []);
vendorRequestList.factory('vendorListAPI', function($http) {

	var vendorRequestList = {};
	
	
	
	vendorRequestList.requestList = function() {
	
		return $http({
			method : 'GET',
			url : 'user/requestVendorList/'			
		});
	};
	
	return vendorRequestList;
});
