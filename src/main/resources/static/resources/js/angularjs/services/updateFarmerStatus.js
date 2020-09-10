var updateFarmerStatus = angular.module('UpdateFarmerStatus-service', []);
updateFarmerStatus.factory('updateFarmerStatusAPI', function($http) {

	var updateFarmerStatus = {};
		
	updateFarmerStatus.updateFarmerStatusData = function(updatedData){

		console.log(updatedData);
		return $http({
				method : 'POST',
				url : 'user/updateFarmerStatus',
				data : updatedData 

		});
	};


	return updateFarmerStatus;
});
