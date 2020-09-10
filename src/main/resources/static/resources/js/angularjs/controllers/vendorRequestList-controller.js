var vendorRequestListController = angular.module('vendorRequestList-Controller', []);

vendorRequestListController.controller("vendorRequestListController",function(vendorListAPI,$scope,$cookieStore){
    $scope.requestList1 = [];
    
    
    vendorListAPI.requestList().success(function(res){
    	
        $scope.requestList1 = res;
        console.log($scope.requestList1);
	
	});


});
