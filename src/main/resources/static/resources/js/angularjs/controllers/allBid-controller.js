var allBidsController = angular.module('allBid-controller', []);
allBidsController.controller("allBidsController",function(allBidAPI,$scope,$cookieStore,toaster){
    $scope.bidList = [];
 
    
    $scope.global = $cookieStore.get("globals") || {};

    $scope.vendorId= $scope.global.currentUser.id;

    allBidAPI.listBid().success(function(res){
 
        $scope.bidList = res;
        console.log("res= "+res);
	
	});
});