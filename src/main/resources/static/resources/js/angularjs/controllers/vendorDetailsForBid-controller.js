var vendorDetailsForBidController = angular.module('vendorDetailsForBid-Controller', []);

vendorDetailsForBidController.controller("vendorDetailsForBidController",function(vendorDetailsForBidAPI,$scope,$cookieStore){

    $scope.bidList = [];
    $scope.global = $cookieStore.get("globals") || {};
    
    var farmerId= $scope.global.currentUser.id;
 
    
    
    vendorDetailsForBidAPI.listBid(farmerId).success(function(res){
  
    		$scope.bidList = res;
    		console.log($scope.bidList);
    		
	    	
    		
	
	});
	
	

});
