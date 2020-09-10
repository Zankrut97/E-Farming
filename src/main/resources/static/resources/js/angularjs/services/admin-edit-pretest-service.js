var editPreTest = angular.module('admin-edit-pretest-service', []);

editPreTest.factory('EditPreTestAPI', function($http) {

	var editPreTestAPI = {};

	editPreTestAPI.createBid = function(bidData) {
		return $http({
			method : 'POST',
			url : 'user/cropBidRegistration',
			data : bidData,
			
		});
	};
	
	return editPreTestAPI;

	
});
