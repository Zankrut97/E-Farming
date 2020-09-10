var viewBidController = angular.module('viewBid-Controller', []);

viewBidController.controller("viewBidController",function(viewBidAPI,$scope,$cookieStore){

    $scope.bidList = [];
    $scope.global = $cookieStore.get("globals") || {};
    
    var farmerId= $scope.global.currentUser.id;
  //  console.log( $scope.global);
    
    
    viewBidAPI.listBid(farmerId).success(function(res){
   // console.log(res);
    $scope.bidList = res;
	
	});


});
