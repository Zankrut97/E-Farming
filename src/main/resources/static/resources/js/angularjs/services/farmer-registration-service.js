var farmerRegisterService = angular.module('farmer-register-service', []);

farmerRegisterService.factory('FarmerRegisterAPI', function($http) {

	var farmerRegisterAPI = {};
	
	farmerRegisterAPI.createform = function(formData) {
	console.log(formData);
		return $http({
			method : 'POST',
			url : 'user/farmerRegistration',
			data : formData,
			
		});
	};
	
	return farmerRegisterAPI;
});
