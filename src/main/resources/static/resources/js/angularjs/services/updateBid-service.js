var updateBid = angular.module('UpdateBid-service', []);
updateBid.factory('updateBidAPI', function($http) {

	var updateBid = {};
		
	updateBid.updateBidData = function(updatedData){

		//console.log(updatedData);
		return $http({
				method : 'POST',
				url : 'user/updateBidValue',
				data : updatedData 

		});
	};


	return updateBid;
});
