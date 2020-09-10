var bidHistoryController = angular.module('bidHistory-controller', []);
bidHistoryController.controller("bidHistoryController",function(bidHistoryAPI,$scope,$cookieStore,toaster){
    $scope.bidList = [];
 	$scope.modal = [];
    
    $scope.global = $cookieStore.get("globals") || {};

    $scope.vendorId= $scope.global.currentUser.id;

    bidHistoryAPI.listBid($scope.vendorId).success(function(res){
 
        $scope.bidList = res;
        console.log(res);
	
	});

	$scope.openModel = function(index){

			$scope.modal = $scope.bidList[index];
			console.log($scope.modal);
	}
});