
var CropSuggestionFormService = angular.module('CropSuggestionForm-service', []);

CropSuggestionFormService.factory('CropSuggestionFormAPI', function($http) {

	var cropSuggestionFormAPI = {};
	
	cropSuggestionFormAPI.getCropName = function(Data) {
		
		console.log(Data.name);
		 return $http({
			method : 'GET',
			url : 'user/getCropDemandBySoil/'+ Data.name
			
		}); 
		
	};
	
	return cropSuggestionFormAPI;
});