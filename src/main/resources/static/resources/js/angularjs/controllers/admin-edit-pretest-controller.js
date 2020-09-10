/**
 * 
 */
'use strict';

var editPreTestController = angular.module('admin-edit-pretest-controller', ['ui.router','oc.lazyLoad']);

editPreTestController.controller('editPreTestController', function($scope,$state, $rootScope, $location,toaster,$uibModal,productList,EditPreTestAPI,$cookieStore){
	
	$scope.global = $cookieStore.get("globals") || {};
	$scope.productList = [];
	$scope.productList = productList;
	
	//console.log($scope.productList);
	
	
	$scope.createBid = function($event){
	
			
			$scope.bidInfo.farmerId= $scope.global.currentUser.id;
			
		
			EditPreTestAPI.createBid($scope.bidInfo).success(function(res){
			
			toaster.pop('success', "Bid Created..");
			
			$state.go("viewBid");
		    $rootScope.currentPage = "/farmer/viewBid"

	});

		
		
	}

    })