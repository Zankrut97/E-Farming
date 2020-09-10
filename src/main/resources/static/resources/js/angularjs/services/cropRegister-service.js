
var CropRegisterService = angular.module('CropRegistration-service', []);

CropRegisterService.factory('CropRegisterAPI', function($http) {

	var cropRegisterAPI = {};
	
	cropRegisterAPI.registerCrop = function(Data) {
		
		console.log(Data);
		 return $http({
			method : 'POST',
			url : 'user/registerCrop',
			data : Data
		}); 
		
	};
	
	return cropRegisterAPI;
});