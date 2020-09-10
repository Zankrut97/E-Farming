var vendorRegisterService = angular.module('vendor-register-service', []);

vendorRegisterService.factory('VendorRegisterAPI', function($http) {

	var vendorRegisterAPI = {};
	
	
	
	vendorRegisterAPI.createform = function(formData) {
	console.log(formData);
		return $http({
			method : 'POST',
			url : 'user/vendorRegistration',
			data : formData,
			
		});
	};
	
	return vendorRegisterAPI;
});