
var CropSuggestionService = angular.module('CropSuggestion-service', []);

CropSuggestionService.factory('CropSuggestionAPI', function($http) {

	var cropSuggestionAPI = {};
	
	cropSuggestionAPI.getDemandValue = function() {
	
		return $http({
			method : 'GET',
			url : 'user/getCropDemand',
			
		});
	};
	
	return cropSuggestionAPI;
});